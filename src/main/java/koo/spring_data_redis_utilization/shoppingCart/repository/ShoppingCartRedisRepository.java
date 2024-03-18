package koo.spring_data_redis_utilization.shoppingCart.repository;

import koo.spring_data_redis_utilization.shoppingCart.domain.entity.Item;
import koo.spring_data_redis_utilization.shoppingCart.domain.entity.ShoppingCartUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ShoppingCartRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public Long add(ShoppingCartUser shoppingCartUser, Item item) {
        Long result = redisTemplate
                .opsForSet()
                .add("user:" + Long.toString(shoppingCartUser.getId()) + ":cart", "item:" + Long.toString(item.getId()) + ":cart");// SADD (e.g. user:1:cart, item:1:cart)

        return result;
    }

    public Set<String> get(ShoppingCartUser shoppingCartUser) {
        Set<String> result = redisTemplate
                .opsForSet()
                .members("user:" + Long.toString(shoppingCartUser.getId()) + ":cart");// SMEMBERS

        return result;
    }

}
