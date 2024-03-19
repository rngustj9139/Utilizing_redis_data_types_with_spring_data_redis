package koo.spring_data_redis_utilization.loginSession.domain.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_user_id")
    private Long id;

    private String username;

    private String password;

}
