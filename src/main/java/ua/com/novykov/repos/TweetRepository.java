package ua.com.novykov.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.novykov.model.Tweets;

public interface TweetRepository extends JpaRepository<Tweets, Long> {

}
