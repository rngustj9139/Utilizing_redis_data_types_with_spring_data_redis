package koo.spring_data_redis_utilization.distributedLock.repository;

import koo.spring_data_redis_utilization.distributedLock.domain.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
