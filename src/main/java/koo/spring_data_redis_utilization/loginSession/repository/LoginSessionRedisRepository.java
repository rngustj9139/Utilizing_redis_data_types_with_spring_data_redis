package koo.spring_data_redis_utilization.loginSession.repository;

import koo.spring_data_redis_utilization.loginSession.domain.entity.LoginUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LoginSessionRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public void setLoginSessionWithHash(LoginUser user, String session) {
        redisTemplate
                .opsForHash()
                .put(session, user.getId(), "premium"); // HSET abcd id 1 grade premium
    }

    public Object checkLoginSessionWithHash(LoginUser user, String session) {
        Object checkSession = redisTemplate
                .opsForHash()
                .get(session, user.getId());

        return checkSession;
    }

}
