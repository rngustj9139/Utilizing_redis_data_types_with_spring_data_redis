package koo.spring_data_redis_utilization.snsActivityFeed.api;

import koo.spring_data_redis_utilization.snsActivityFeed.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FeedRestController {

    private final FeedService feedService;

    public void save(@RequestBody) {

    }

}
