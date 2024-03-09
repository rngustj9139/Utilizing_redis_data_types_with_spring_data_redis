package koo.spring_data_redis_utilization.distributedLock.api;

import koo.spring_data_redis_utilization.distributedLock.dto.BalanceUpdateRequestDto;
import koo.spring_data_redis_utilization.distributedLock.facade.LettuceLockBalanceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceRestController {

    private final LettuceLockBalanceFacade lettuceLockBalanceFacade;

    @PostMapping("/api/balance/increase")
    public Boolean increaseBalance(@RequestBody BalanceUpdateRequestDto balanceUpdateRequestDto) throws InterruptedException {
        Boolean result = lettuceLockBalanceFacade.increase(balanceUpdateRequestDto.getUserId(), balanceUpdateRequestDto.getBalanceQuantity());

        return result;
    }

    @PostMapping("/api/balance/decrease")
    public Boolean decreaseBalance(@RequestBody BalanceUpdateRequestDto balanceUpdateRequestDto) throws InterruptedException {
        Boolean result = lettuceLockBalanceFacade.decrease(balanceUpdateRequestDto.getUserId(), balanceUpdateRequestDto.getBalanceQuantity());

        return result;
    }

}
