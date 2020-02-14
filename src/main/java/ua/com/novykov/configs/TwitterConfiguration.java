package ua.com.novykov.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@RequiredArgsConstructor
public class TwitterConfiguration {

    @Value("twitter4j.oauth.api-key")
    private String apiKey;
    @Value("twitter4j.oauth.api-secret-key")
    private String apiSecretKey;
    @Value("twitter4j.oauth.access-token")
    private String accessToken;
    @Value("twitter4j.oauth.access-token-secret")
    private String accessTokenSecret;

    @Bean
    public Twitter getConnection() {
        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true)
                .setOAuthConsumerKey(apiKey)
                .setOAuthConsumerSecret(apiSecretKey)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(configurationBuilder.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
