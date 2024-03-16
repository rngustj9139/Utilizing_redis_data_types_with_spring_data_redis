package koo.spring_data_redis_utilization.snsActivityFeed.repository;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
