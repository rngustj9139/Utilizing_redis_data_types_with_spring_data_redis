package koo.spring_data_redis_utilization.distributedLock.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Balance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // 계좌를 소유한 고객의 id
    private Long balanceQuantity;

    public Long getBalanceQuantity() {
        return balanceQuantity;
    }

    public void increase(Long requestQuantity) {
        balanceQuantity += requestQuantity;
    }

    public void decrease(Long requestQuantity) {
        if (balanceQuantity - requestQuantity < 0) {
            return;
        }

        balanceQuantity -= requestQuantity;
    }

}
