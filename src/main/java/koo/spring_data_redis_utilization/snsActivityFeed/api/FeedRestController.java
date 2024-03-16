package koo.spring_data_redis_utilization.snsActivityFeed.api;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.dto.FeedSaveRequestDto;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.dto.LikeFeedRequestDto;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.Feed;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.LikeFeedActivity;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import koo.spring_data_redis_utilization.snsActivityFeed.repository.LikeFeedActivityRepository;
import koo.spring_data_redis_utilization.snsActivityFeed.repository.SnsActivityFeedRedisRepository;
import koo.spring_data_redis_utilization.snsActivityFeed.service.FeedService;
import koo.spring_data_redis_utilization.snsActivityFeed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeedRestController {

    private final FeedService feedService;

    private final UserService userService;

    private final LikeFeedActivityRepository likeFeedActivityRepository;

    @PostMapping("/api/feed")
    public void save(@RequestBody FeedSaveRequestDto feedSaveRequestDto) {
        User user = userService.findById(feedSaveRequestDto.getUserId());
        Feed feed = new Feed();

        feed.setUser(user);
        feed.setContent(feedSaveRequestDto.getContent());

        feedService.save(feed);
    }

    @PatchMapping("/api/feed")
    public Long likeFeed(@RequestBody LikeFeedRequestDto likeFeedRequestDto) {
        Feed feed = feedService.findById(likeFeedRequestDto.getFeedId());
        User user = userService.findById(likeFeedRequestDto.getUserId());

        LikeFeedActivity likeFeedActivity = new LikeFeedActivity();
        likeFeedActivity.setUser(user);
        likeFeedActivity.setFeed(feed);

        likeFeedActivityRepository.save(likeFeedActivity);
        Long result = feedService.setFanOutFeedList(likeFeedRequestDto.getUserId(), likeFeedRequestDto.getFeedId());

        return result;
    }

    @GetMapping("/api/feed")
    public List<Feed> getActivityFeedList(@RequestBody ) {

    }

}
