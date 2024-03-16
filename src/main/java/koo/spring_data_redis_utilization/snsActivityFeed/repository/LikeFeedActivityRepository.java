package koo.spring_data_redis_utilization.snsActivityFeed.repository;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.LikeFeedActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeFeedActivityRepository extends JpaRepository<LikeFeedActivity, Long> {
}
