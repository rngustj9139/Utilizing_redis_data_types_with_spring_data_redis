package koo.spring_data_redis_utilization.distributedLock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceUpdateRequestDto {

    public Long userId;
    public Long balanceQuantity;

}
