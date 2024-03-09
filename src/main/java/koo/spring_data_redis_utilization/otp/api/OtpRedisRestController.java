package koo.spring_data_redis_utilization.otp.api;

import koo.spring_data_redis_utilization.otp.dto.OtpGenerateRequestDto;
import koo.spring_data_redis_utilization.otp.dto.OtpVerifyRequestDto;
import koo.spring_data_redis_utilization.otp.service.OtpRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OtpRedisRestController {

    private final OtpRedisService otpRedisService;

    @PostMapping("/api/otp/generate")
    public String generateOtp(@RequestBody OtpGenerateRequestDto otpGenerateRequestDto) {
        String otpNumber = otpRedisService.generateOtp(otpGenerateRequestDto.getPhoneNumber());

        return otpNumber;
    }

    @PostMapping("/api/otp/verify")
    public String verifyOtp(@RequestBody OtpVerifyRequestDto otpVerifyRequestDto) {
        String result = otpRedisService.verifyOtp(otpVerifyRequestDto);

        return result;
    }

}
