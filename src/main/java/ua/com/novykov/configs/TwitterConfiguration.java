package ua.com.novykov.configs;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix ="twitter4j.oauth")
@RequiredArgsConstructor
public class TwitterConfiguration {

//    @Value("${api-key}")
    private String apiKey;
//    @Value("${api-secret-key}")
    private String apiSecretKey;
//    @Value("${access-token}")
    private String accessToken;
//    @Value("${access-token-secret}")
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
