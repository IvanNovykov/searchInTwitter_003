package ua.com.novykov.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "tweets")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authorOfTweet;
    private String text;
    private LocalDateTime date;
}