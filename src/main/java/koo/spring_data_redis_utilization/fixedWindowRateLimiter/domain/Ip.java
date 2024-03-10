package koo.spring_data_redis_utilization.fixedWindowRateLimiter.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ip {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userIp;

    private String userName;

    private LocalTime lastRequestTime;

}
