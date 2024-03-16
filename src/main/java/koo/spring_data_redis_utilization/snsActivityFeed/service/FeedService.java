package koo.spring_data_redis_utilization.snsActivityFeed.service;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.Feed;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import koo.spring_data_redis_utilization.snsActivityFeed.repository.FeedRepository;
import koo.spring_data_redis_utilization.snsActivityFeed.repository.SnsActivityFeedRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    private final SnsActivityFeedRedisRepository snsActivityFeedRedisRepository;

    public void save(Feed feed) {
        feedRepository.save(feed);
    }

    public Feed findById(Long feedId) {
        return feedRepository.findById(feedId).orElseThrow();
    }

    public Long setFanOutFeedList(Long giveLikeUserId, Long feedId) {
        Long result = snsActivityFeedRedisRepository.setLikeActivity(giveLikeUserId, feedId);

        return result;
    }

    public List<Feed> getFanOutFeedList() {
        snsActivityFeedRedisRepository.getLikeActivity();
    }

}
