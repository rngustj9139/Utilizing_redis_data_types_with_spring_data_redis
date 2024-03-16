package koo.spring_data_redis_utilization.snsActivityFeed.repository;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.Feed;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SnsActivityFeedRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    private final FeedRepository feedRepository;

    public Long setLikeActivity(Long giveLikeUserId, Long feedId) {
        Feed feed = feedRepository.findById(feedId).orElseThrow();
        Long writerUserId = feed.getUser().getId();

        Long result = redisTemplate
                .opsForList()
                .leftPush("user:" + Long.toString(writerUserId) + ":feed", "user " + Long.toString(giveLikeUserId) + " liked a post");

        return result;
    }

    public List<String> getLikeActivity(User user) {
        List<String> range = redisTemplate
                .opsForList()
                .range("user:" + Long.toString(user.getId()) + ":feed", 0, 9);

        return range;
    }

}
