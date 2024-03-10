package koo.spring_data_redis_utilization.fixedWindowRateLimiter.repository;

import koo.spring_data_redis_utilization.fixedWindowRateLimiter.domain.Ip;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RateLimiterRedisRepository { // Fixed Window Rate Limiter(비울 계산기) => 시스템 안정성/보안을 위해 고정된 시간 (ex: 1분) 동안의 요청의 수를 제한하는 기법

    private final RedisTemplate<String, String> redisTemplate;

    public Long checkRate(Ip ip) {
        Long increment = 0L;

        String requestCount = redisTemplate
                .opsForValue()
                .get(ip.getUserIp() + ":1");// 0.0.0.0:1 => ip와 고정시간을 의미 (1분)

        if (requestCount == null) { // 첫 요청인 경우
            redisTemplate
                    .opsForValue()
                    .set(ip.getUserIp() + ":1", "1", Duration.ofMillis(6000)); // value는 1분내의 요청 횟수를 의미

            return 1L;
        } else {
            increment = redisTemplate
                    .opsForValue()
                    .increment(ip.getUserIp() + ":1");
        }

        return increment;
    }

}
