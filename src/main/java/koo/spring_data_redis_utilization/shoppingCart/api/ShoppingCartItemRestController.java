package koo.spring_data_redis_utilization.shoppingCart.api;

import koo.spring_data_redis_utilization.shoppingCart.domain.dto.ShoppingCartAddItemRequestDto;
import koo.spring_data_redis_utilization.shoppingCart.domain.dto.ShoppingCartGetItemListRequestDto;
import koo.spring_data_redis_utilization.shoppingCart.domain.dto.ShoppingCartGetItemListResponseDto;
import koo.spring_data_redis_utilization.shoppingCart.domain.entity.Item;
import koo.spring_data_redis_utilization.shoppingCart.domain.entity.ShoppingCartUser;
import koo.spring_data_redis_utilization.shoppingCart.service.ItemService;
import koo.spring_data_redis_utilization.shoppingCart.service.ShoppingCartUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartItemRestController {

    private final ItemService itemService;

    private final ShoppingCartUserService shoppingCartUserService;

    @PostMapping("/api/cart/create/item")
    public void createItem() {
        Item item = new Item();

        itemService.save(item);
    }

    @PostMapping("/api/cart/item")
    public Long addItem(@RequestBody ShoppingCartAddItemRequestDto shoppingCartAddItemRequestDto) {
        ShoppingCartUser shoppingCartUser = shoppingCartUserService.findById(shoppingCartAddItemRequestDto.getUserId());
        Item item = itemService.findById(shoppingCartAddItemRequestDto.getItemId());

        item.setShoppingCartUser(shoppingCartUser);

        Long result = itemService.add(shoppingCartUser, item);

        return result;
    }

    @GetMapping("/api/cart/item")
    public List<ShoppingCartGetItemListResponseDto> getItems(@RequestBody ShoppingCartGetItemListRequestDto shoppingCartGetItemListRequestDto) {
        log.info("userId == {}", shoppingCartGetItemListRequestDto.getUserId());
        ShoppingCartUser shoppingCartUser = shoppingCartUserService.findById(shoppingCartGetItemListRequestDto.getUserId());

        List<Item> items = itemService.get(shoppingCartUser);

        List<ShoppingCartGetItemListResponseDto> results = items.stream()
                .map(i -> new ShoppingCartGetItemListResponseDto(i.getId(), i.getShoppingCartUser().getId()))
                .collect(Collectors.toList());

        return results;
    }

}
