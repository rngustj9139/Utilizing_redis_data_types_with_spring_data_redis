package koo.spring_data_redis_utilization.shoppingCart.repository;

import koo.spring_data_redis_utilization.shoppingCart.domain.entity.ShoppingCartUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartUserRepository extends JpaRepository<ShoppingCartUser, Long> {
}
