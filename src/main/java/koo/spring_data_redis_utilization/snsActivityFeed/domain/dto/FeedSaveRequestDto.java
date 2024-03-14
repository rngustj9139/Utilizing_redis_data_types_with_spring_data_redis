package koo.spring_data_redis_utilization.snsActivityFeed.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class FeedSaveRequestDto {

    public Long userId;

    public String content; // 작성글 내용

}
