package koo.spring_data_redis_utilization.snsActivityFeed.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class LikeActivity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



}
