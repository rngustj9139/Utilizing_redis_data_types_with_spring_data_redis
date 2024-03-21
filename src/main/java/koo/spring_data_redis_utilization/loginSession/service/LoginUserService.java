package koo.spring_data_redis_utilization.loginSession.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import koo.spring_data_redis_utilization.loginSession.domain.SessionConst;
import koo.spring_data_redis_utilization.loginSession.domain.entity.LoginUser;
import koo.spring_data_redis_utilization.loginSession.repository.LoginSessionRedisRepository;
import koo.spring_data_redis_utilization.loginSession.repository.LoginUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LoginUserService {

    private final LoginUserRepository loginUserRepository;

    private final LoginSessionRedisRepository loginSessionRedisRepository;

    public int randomStrLength = 20;

    public boolean useLetters = true;

    public boolean useNumbers = true;

    public void register(LoginUser user) {
        loginUserRepository.save(user);
    }

    public Optional<LoginUser> findByUsername(String username) {
        List<LoginUser> results = loginUserRepository.findAll();

        Optional<LoginUser> result = results.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();

        return result;
    }

    public void setLoginSessionWithHash(HttpServletResponse response, LoginUser loginUser) {
        String randomStr = RandomStringUtils.random(randomStrLength, useLetters, useNumbers);
        loginSessionRedisRepository.setLoginSessionWithHash(loginUser, randomStr);

        Cookie cookie = new Cookie(SessionConst.LOGIN_USER, randomStr);
        cookie.setMaxAge(30); // 쿠키의 expiration 타임 설정
        cookie.setPath("/"); // 모든 경로에서 접근 가능하도록 설정
        response.addCookie(cookie);
    }

    public void checkLoginSessionWithHash(LoginUser user, String session) {
        Object checkLoginSessionWithHash = loginSessionRedisRepository.checkLoginSessionWithHash(user, session);

        log.info("======== checkLoginSessionWithHash: {} ========", checkLoginSessionWithHash);
    }

}
