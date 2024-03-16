package koo.shoppingCart.repository;

import koo.shoppingCart.domain.entity.Item;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ShoppingCartRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public Long add(User user, Item item) {
        Long result = redisTemplate
                .opsForSet()
                .add("user:" + Long.toString(user.getId()) + ":cart", "item:" + Long.toString(item.getId()) + ":cart");// SADD (e.g. user:1:cart, item:1:cart)

        return result;
    }

    public Set<String> get(User user) {
        Set<String> result = redisTemplate
                .opsForSet()
                .members("user:" + Long.toString(user.getId()) + ":cart");// SMEMBERS

        return result;
    }

}
