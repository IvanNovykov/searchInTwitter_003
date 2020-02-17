package ua.com.novykov.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "tweets")
<<<<<<< HEAD
@Data
@Builder
=======
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> b67360e8e4c789930caba2c531cbf51d29caecfd
public class Tweets {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String authorOfTweet;
    private String text;
    private LocalDateTime date;
}