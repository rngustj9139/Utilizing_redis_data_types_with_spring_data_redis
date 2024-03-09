package koo.spring_data_redis_utilization.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DistriburedLockRedisService {

    private final DistriburedLockRedisService distriburedLockRedisService;

    public Boolean increase() {

    }

    public Boolean decrease() {

    }

}
