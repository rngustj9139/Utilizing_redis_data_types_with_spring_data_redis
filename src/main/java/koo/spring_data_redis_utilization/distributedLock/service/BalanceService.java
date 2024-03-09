package koo.spring_data_redis_utilization.distributedLock.service;

import koo.spring_data_redis_utilization.distributedLock.domain.Balance;
import koo.spring_data_redis_utilization.distributedLock.repository.BalanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BalanceService {

    private final BalanceRepository balanceRepository;

    public void increase(Long userId, Long requestQuantity) {
        Balance balance = balanceRepository.findById(userId).orElseThrow();
        balance.increase(requestQuantity);
        balanceRepository.saveAndFlush(balance);
    }

    public void decrease(Long userId, Long requestQuantity) {
        Balance balance = balanceRepository.findById(userId).orElseThrow();
        balance.decrease(requestQuantity);
        balanceRepository.saveAndFlush(balance);
    }

}
