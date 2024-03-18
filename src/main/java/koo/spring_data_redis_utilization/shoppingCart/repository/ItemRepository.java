package koo.spring_data_redis_utilization.shoppingCart.repository;

import koo.spring_data_redis_utilization.shoppingCart.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
