package koo.shoppingCart.service;

import koo.shoppingCart.domain.entity.Item;
import koo.shoppingCart.repository.ShoppingCartRedisRepository;
import koo.spring_data_redis_utilization.snsActivityFeed.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ShoppingCartRedisRepository shoppingCartRedisRepository;

    private final

    public Long add(User user, Item item) {
        Long result = shoppingCartRedisRepository.add(user, item);

        return result;
    }

    public List<Item> get(User user) {
        Set<String> results = shoppingCartRedisRepository.get(user);
        List<Item> savedItemList = new ArrayList<>();

        for (String result : results) {
            String[] splitResult = result.split(":");// (e.g. user:1:cart, item:1:cart)



            savedItemList.add();
        }

        return savedItemList;
    }

}
