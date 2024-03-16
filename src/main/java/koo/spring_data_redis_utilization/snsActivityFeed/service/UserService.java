package koo.spring_data_redis_utilization.snsActivityFeed.service;

import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import koo.spring_data_redis_utilization.snsActivityFeed.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

}
