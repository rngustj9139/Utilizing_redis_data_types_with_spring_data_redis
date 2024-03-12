package koo.spring_data_redis_utilization.snsActivityFeed.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SnsActivityFeedRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public void likeActivity() {
        redisTemplate
                .opsForList()
                .leftPush()
    }

}
