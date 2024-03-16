package koo.spring_data_redis_utilization.snsActivityFeed.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LikeFeedRequestDto {

    public Long userId;

    public Long feedId;

}
