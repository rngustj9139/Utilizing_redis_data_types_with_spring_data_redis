package koo.spring_data_redis_utilization.snsActivityFeed.domain.dto;

import lombok.Data;

@Data
public class LikeFeedRequestDto {

    public Long userId;

    public Long feedId;

}
