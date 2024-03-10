package koo.spring_data_redis_utilization.fixedWindowRateLimiter.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RateLimiterRedisRepository {

    private final RedisTemplate<String, Long> redisTemplate;

    public Long checkRate(String ip) {

    }

}
