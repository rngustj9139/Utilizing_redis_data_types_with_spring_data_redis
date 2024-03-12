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

    private Long likeSendUserId; // 피드에 좋아요를 누른 유저의 고유 id

    private Integer likeGetUserId; // 자신의 피드에 좋아요를 받은 유저의 고유 id

}
