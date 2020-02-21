package ua.com.novykov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import twitter4j.TwitterException;
import ua.com.novykov.service.TweetService;

@Controller
@RequiredArgsConstructor
public class TweetsController {
    private final TweetService tweetService;

    @GetMapping("/save/defaults")
    public String save() throws TwitterException {
        tweetService.saveTweets();
        return "save";
    }
}