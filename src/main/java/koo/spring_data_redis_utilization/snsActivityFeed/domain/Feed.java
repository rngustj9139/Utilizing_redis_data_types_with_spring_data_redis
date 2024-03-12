package koo.spring_data_redis_utilization.snsActivityFeed.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

import javax.annotation.processing.Generated;

@Entity
@NoArgsConstructor
public class Feed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // 피드 작성자의 고유 id

    private Integer likeCount;

    private String content;

}
