package ua.com.novykov.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.novykov.model.Tweets;

@Repository
public interface TweetRepository extends JpaRepository<Tweets, Long> {

}