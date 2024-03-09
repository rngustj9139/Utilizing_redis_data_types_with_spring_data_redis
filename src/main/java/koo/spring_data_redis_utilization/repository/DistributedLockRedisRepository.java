package koo.spring_data_redis_utilization.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DistributedLockRedisRepository { // Distributed Lock(분산 락을 위한 레포지토리, DB Lock을 사용하면 성능 저하가 발생하기 때문에 Redis를 이용해 분산 락 구현)

    private final RedisTemplate<String, Integer> redisTemplate;

    public Boolean lock() {
        return redisTemplate
                .opsForValue() // String 자료구조 이용
                .setIfAbsent("lock", 1); // SET lock 1 NX (해당 키가 존재하지 않아야만 생성 가능)
    }

    public Boolean unlick() {
        return redisTemplate
                .delete("lock");
    }

}
