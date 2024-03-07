package koo.spring_data_redis_utilization.dto;

import lombok.Data;

@Data
public class OtpGenerateRequestDto {

    private String phoneNumber;

    public OtpGenerateRequestDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
