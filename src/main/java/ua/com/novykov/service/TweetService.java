package ua.com.novykov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import ua.com.novykov.model.Tweets;
import ua.com.novykov.repos.TweetRepository;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TweetService {
    private final Twitter twitter;
    private final TweetRepository tweetRepository;

    public List<Tweets> searchTweets(@RequestParam(name = "queryText", required = false)String queryText) throws TwitterException {
        List<Tweets> tweets = new ArrayList<>();
        twitter4j.Query query = new twitter4j.Query(queryText);
        query.setCount(100);
        QueryResult queryResult = twitter.search(query);
        List<Status> statuses = queryResult.getTweets();
        statuses.stream().forEach(status -> {
            Tweets tweet = Tweets.builder()
                    .id(status.getId())
                    .authorOfTweet(status.getUser().getName())
                    .text(status.getText())
                    .date(convertDateToLocalDateTime(status.getCreatedAt()))
                    .build();
            tweets.add(tweet);
        });
        return tweets;
    }

    private LocalDateTime convertDateToLocalDateTime(Date tweetDate) {
        return tweetDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Scheduled(cron = "0 0/01 * * * ?")
    public void saveTweets() throws TwitterException {
        tweetRepository.saveAll(searchTweets("Java"));
    }
}