package koo.spring_data_redis_utilization.shoppingCart.api;

import koo.spring_data_redis_utilization.shoppingCart.domain.entity.ShoppingCartUser;
import koo.spring_data_redis_utilization.shoppingCart.service.ShoppingCartUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShoppingCartUserRestController {

    private final ShoppingCartUserService shoppingCartUserService;

    @PostMapping("/api/cart/user")
    public void save() {
        ShoppingCartUser shoppingCartUser = new ShoppingCartUser();

        shoppingCartUserService.save(shoppingCartUser);
    }

}
