package koo.spring_data_redis_utilization.shoppingCart.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private ShoppingCartUser shoppingCartUser;

    //== 연관관계 편의 메서드 ==//
    public void setShoppingCartUser(ShoppingCartUser shoppingCartUser) {
        this.shoppingCartUser = shoppingCartUser;
        shoppingCartUser.getItems().add(this);
    }

}
