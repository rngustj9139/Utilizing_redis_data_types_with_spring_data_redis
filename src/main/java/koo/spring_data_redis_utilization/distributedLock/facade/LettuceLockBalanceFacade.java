package koo.spring_data_redis_utilization.distributedLock.facade;

import koo.spring_data_redis_utilization.distributedLock.repository.DistributedLockRedisRepository;
import koo.spring_data_redis_utilization.distributedLock.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LettuceLockBalanceFacade {

    private final DistributedLockRedisRepository distributedLockRedisRepository;
    private final BalanceService balanceService;

    public void increase(Long userId, Long requestQuantity) throws InterruptedException {
        while (!distributedLockRedisRepository.lock(userId)) {
            Thread.sleep(100); // 이미 lock이 걸려있을 경우는 100 milis(0.1초)의 텀을 발생시켜 redis의 부하를 줄인다. (Lettuce는 Spin Lock 방식이므로 부하를 줄여야한다.)
        }

        // lock이 걸려 있지 않은 경우
        try {
            balanceService.increase(userId, requestQuantity);
        } finally {
            distributedLockRedisRepository.unlock(userId);
        }
    }

    public void decrease(Long userId, Long requestQuantity) throws InterruptedException {
        while (!distributedLockRedisRepository.lock(userId)) {
            Thread.sleep(100); // 이미 lock이 걸려있을 경우는 100 milis(0.1초)의 텀을 발생시켜 redis의 부하를 줄인다. (Lettuce는 Spin Lock 방식이므로 부하를 줄여야한다.)
        }

        // lock이 걸려 있지 않은 경우
        try {
            balanceService.decrease(userId, requestQuantity);
        } finally {
            distributedLockRedisRepository.unlock(userId);
        }
    }

}
