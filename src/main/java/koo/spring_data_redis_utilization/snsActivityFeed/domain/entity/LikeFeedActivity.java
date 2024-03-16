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
public class LikeFeedActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likeFeedActivity_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 피드에 좋아요 클릭 활동을 한 타 유저

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "likeFeedActivity")
    private Feed feed; // 좋아요 클릭 활동과 일대일 대응 되는 Feed

    //== 연관관계 편의 메서드 ==//
    public void setUser(User user) {
        this.user = user;
        user.getLikeFeed().add(this);
    }

    //== 연관관계 편의 메서드 ==//
    public void setFeed(Feed feed) {
        this.feed = feed;
        feed.setLikeFeedActivity(this);
    }

}
