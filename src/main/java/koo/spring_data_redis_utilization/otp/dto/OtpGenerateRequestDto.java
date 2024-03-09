package koo.spring_data_redis_utilization.otp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OtpGenerateRequestDto {

    private String phoneNumber;

    public OtpGenerateRequestDto(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
