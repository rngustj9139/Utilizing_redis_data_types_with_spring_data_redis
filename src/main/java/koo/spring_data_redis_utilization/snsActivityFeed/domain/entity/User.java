package koo.spring_data_redis_utilization.snsActivityFeed.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // 칼럼 명 지정
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Feed> selfWriteFeedList = new ArrayList<>(); // 작성한 게시글 리스트

    @OneToMany(mappedBy = "user")
    private List<LikeFeedActivity> likeFeed = new ArrayList<>(); // 좋아요 누른 피드 리스트

}
