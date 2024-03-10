package koo.spring_data_redis_utilization.fixedWindowRateLimiter.service;

import koo.spring_data_redis_utilization.fixedWindowRateLimiter.domain.Ip;
import koo.spring_data_redis_utilization.fixedWindowRateLimiter.repository.RateLimiterRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RateLimiterService {

    private final RateLimiterRedisRepository rateLimiterRedisRepository;

    public Boolean checkRate(Ip ip) {
        Long count = rateLimiterRedisRepository.checkRate(ip);

        if (count > 20) { // 1분이라는 고정된 시간 속에서 요청한 횟수가 20회가 넘으면
            return false;
        }

        return true;
    }

}
