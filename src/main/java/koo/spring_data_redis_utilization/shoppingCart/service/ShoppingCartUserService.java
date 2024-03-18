package koo.spring_data_redis_utilization.shoppingCart.service;

import koo.spring_data_redis_utilization.shoppingCart.domain.entity.ShoppingCartUser;
import koo.spring_data_redis_utilization.shoppingCart.repository.ShoppingCartUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ShoppingCartUserService {

    private final ShoppingCartUserRepository shoppingCartUserRepository;

    public ShoppingCartUser findById(Long userId) {
        ShoppingCartUser shoppingCartUser = shoppingCartUserRepository.findById(userId).orElseThrow();

        return shoppingCartUser;
    }

    public void save(ShoppingCartUser shoppingCartUser) {
        shoppingCartUserRepository.save(shoppingCartUser);
    }

}
