package koo.spring_data_redis_utilization.snsActivityFeed.api;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import koo.spring_data_redis_utilization.snsActivityFeed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/api/user")
    public void save() {
        User user = new User();
        userService.save(user);
    }

}
