package koo.spring_data_redis_utilization.shoppingCart.domain.dto;

import koo.spring_data_redis_utilization.shoppingCart.domain.entity.ShoppingCartUser;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCartGetItemListResponseDto {

    public Long itemId;

    public Long shoppingCartUserId;

    public ShoppingCartGetItemListResponseDto(Long itemId, Long shoppingCartUserId) {
        this.itemId = itemId;
        this.shoppingCartUserId = shoppingCartUserId;
    }

}
