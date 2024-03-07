package koo.spring_data_redis_utilization.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Getter + @Setter + @toString
@NoArgsConstructor
public class OtpVerifyRequestDto {

    public String phoneNumber;
    public String otpNumber;

    public OtpVerifyRequestDto(String phoneNumber, String otpNumber) {
        this.phoneNumber = phoneNumber;
        this.otpNumber = otpNumber;
    }

}
