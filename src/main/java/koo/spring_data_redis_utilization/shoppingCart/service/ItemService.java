package koo.spring_data_redis_utilization.shoppingCart.service;

import koo.spring_data_redis_utilization.shoppingCart.domain.entity.Item;
import koo.spring_data_redis_utilization.shoppingCart.domain.entity.ShoppingCartUser;
import koo.spring_data_redis_utilization.shoppingCart.repository.ItemRepository;
import koo.spring_data_redis_utilization.shoppingCart.repository.ShoppingCartRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ShoppingCartRedisRepository shoppingCartRedisRepository;

    private final ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }

    public Item findById(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();

        return item;
    }

    public Long add(ShoppingCartUser shoppingCartUser, Item item) {
        Long result = shoppingCartRedisRepository.add(shoppingCartUser, item);

        return result;
    }

    public List<Item> get(ShoppingCartUser shoppingCartUser) {
        Set<String> results = shoppingCartRedisRepository.get(shoppingCartUser);
        List<Item> savedItemList = new ArrayList<>();

        for (String result : results) {
            String[] splitResult = result.split(":");// (e.g. item:1:cart -> ["item", "1", "cart"])

            Item item = itemRepository.findById(Long.valueOf(splitResult[1])).orElseThrow();

            savedItemList.add(item);
        }

        return savedItemList;
    }

}
