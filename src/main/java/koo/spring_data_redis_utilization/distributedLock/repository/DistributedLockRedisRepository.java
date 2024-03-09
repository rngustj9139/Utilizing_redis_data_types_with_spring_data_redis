package koo.spring_data_redis_utilization.distributedLock.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class DistributedLockRedisRepository { // Distributed Lock(분산 락을 위한 레포지토리, DB Lock을 사용하면 성능 저하가 발생하기 때문에 Redis를 이용해 분산 락 구현)

    private final RedisTemplate<String, String> redisTemplate;

    public Boolean lock(Long userId) {
        return redisTemplate
                .opsForValue() // String 자료구조 이용
                .setIfAbsent(userId.toString(), "1"); // SET 1(userId) 1 NX (해당 키가 존재하지 않아야만 생성 가능)
    }

    public Boolean unlock(Long userId) {
        return redisTemplate
                .delete(userId.toString());
    }

}
