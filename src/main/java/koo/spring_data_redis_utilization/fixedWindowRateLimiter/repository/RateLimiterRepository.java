package koo.spring_data_redis_utilization.fixedWindowRateLimiter.repository;

import koo.spring_data_redis_utilization.fixedWindowRateLimiter.domain.Ip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateLimiterRepository extends JpaRepository<Ip, Long> {
}
