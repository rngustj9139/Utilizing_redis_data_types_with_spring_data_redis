package koo.spring_data_redis_utilization.loginSession.service;

import koo.spring_data_redis_utilization.loginSession.domain.entity.LoginUser;
import koo.spring_data_redis_utilization.loginSession.repository.LoginUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LoginUserService {

    private final LoginUserRepository loginUserRepository;

    public void register(LoginUser user) {
        loginUserRepository.save(user);
    }

}
