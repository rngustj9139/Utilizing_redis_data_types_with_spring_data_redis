package koo.spring_data_redis_utilization.snsActivityFeed.repository;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {
}
