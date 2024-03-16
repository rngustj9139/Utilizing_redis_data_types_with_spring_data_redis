package koo.spring_data_redis_utilization.snsActivityFeed.domain.dto;

import lombok.*;

@Getter @Setter
public class FeedSaveRequestDto {

    public Long userId;

    public String content; // 작성글 내용

}
