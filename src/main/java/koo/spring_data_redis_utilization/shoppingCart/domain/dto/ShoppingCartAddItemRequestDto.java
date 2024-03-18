package koo.spring_data_redis_utilization.shoppingCart.domain.dto;

import lombok.Data;

@Data
public class ShoppingCartAddItemRequestDto {

    public Long userId;

    public Long itemId;

}
