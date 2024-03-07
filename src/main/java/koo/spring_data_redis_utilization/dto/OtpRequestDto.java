package koo.spring_data_redis_utilization.dto;

import lombok.Data;

@Data // @Getter + @Setter + @toString
public class OtpRequestDto {

    public String phoneNumber;
    public String otpNumber;

    public OtpRequestDto(String phoneNumber, String otpNumber) {
        this.phoneNumber = phoneNumber;
        this.otpNumber = otpNumber;
    }

}
