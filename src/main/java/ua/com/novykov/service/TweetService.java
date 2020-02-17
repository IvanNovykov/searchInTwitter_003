package ua.com.novykov.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import ua.com.novykov.configs.TwitterConfiguration;
import ua.com.novykov.model.Tweets;
import ua.com.novykov.repos.TweetRepository;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TweetService {
<<<<<<< HEAD
=======
    private final TwitterConfiguration tweetConfiguration;
>>>>>>> b67360e8e4c789930caba2c531cbf51d29caecfd
    private final Twitter twitter;
    private final TweetRepository tweetRepository;

    public List<Tweets> searchTweets(String queryText) throws TwitterException {
        List<Tweets> tweets = new ArrayList<>();
<<<<<<< HEAD
//        Twitter twitter = tweetConfiguration.getConnection();
=======
>>>>>>> b67360e8e4c789930caba2c531cbf51d29caecfd
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

//    @Scheduled(cron = "0 0/03 * * * ?")
    public void saveTweets() throws TwitterException {
        tweetRepository.saveAll(searchTweets("Java"));
    }

    public List<Tweets> getAllTweets() {
        List<Tweets> tweetsList = tweetRepository.findAll();
        return tweetsList;
    }
}