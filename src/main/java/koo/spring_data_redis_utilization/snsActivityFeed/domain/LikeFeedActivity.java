package koo.spring_data_redis_utilization.snsActivityFeed.domain;

import jakarta.persistence.*;

@Entity
public class LikeFeedActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeFeedActivity_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User likeUser; // 피드에 좋아요 클릭 활동을 한 타 유저

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "likeFeedActivity")
    private Feed correspondingFeed; // 좋아요 클릭 활동과 일대일 대응 되는 Feed

}
