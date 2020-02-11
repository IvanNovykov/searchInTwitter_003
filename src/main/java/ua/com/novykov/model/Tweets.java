package ua.com.novykov.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tweets")
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authorOfTweet;
    private String text;
    private LocalDateTime date;

    public Tweets(String authorOfTweet, String text, LocalDateTime date) {
        this.authorOfTweet = authorOfTweet;
        this.text = text;
        this.date = date;
    }
}
