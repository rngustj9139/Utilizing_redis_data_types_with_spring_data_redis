package koo.spring_data_redis_utilization.snsActivityFeed.service;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.Feed;
import koo.spring_data_redis_utilization.snsActivityFeed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedService {

    private final FeedRepository feedRepository;

    public void save(Feed feed) {
        feedRepository.save(feed);
    }

}
