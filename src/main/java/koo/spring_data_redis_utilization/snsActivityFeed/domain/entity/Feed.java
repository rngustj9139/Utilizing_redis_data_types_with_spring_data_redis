package koo.spring_data_redis_utilization.snsActivityFeed.domain.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Feed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // OneToOne, ManyToOne은 디폴트가 즉시로딩(EAGER)이기 때문에 지연로딩(LAZY)로 바꿔준다. => 진짜 DB에서 맴버를 가져오는 것이 아닌 가짜 프록시 객체를 갖는다. 멤버를 손댈때 진짜 DB에서 정보를 가져온다.
    @JoinColumn(name = "user_id") // 다쪽이 연관관계의 주인, 외래키 관리
    private User user; // 해당 게시글을 작성한 유저

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "likeFeedActivity_id")
    private LikeFeedActivity correspondingLikeFeedActivity;

    private Integer likeCount; // 좋아요 수

    private String content; // 작성글 내용

}
