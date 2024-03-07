package koo.spring_data_redis_utilization.api;

import koo.spring_data_redis_utilization.dto.OtpRequestDto;
import koo.spring_data_redis_utilization.service.OtpRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OtpRedisRestController {

    private final OtpRedisService otpRedisService;

    @PostMapping()
    public String generateOtp(String phoneNumber) {
        String otpNumber = otpRedisService.generateOtp(phoneNumber);

        return otpNumber;
    }

    @PostMapping
    public Boolean verifyOtp(@RequestBody OtpRequestDto otpRequestDto) {
        Boolean result = otpRedisService.verifyOtp(otpRequestDto);

        return result;
    }

}
