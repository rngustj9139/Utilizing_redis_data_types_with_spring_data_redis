package koo.spring_data_redis_utilization.otp.service;

import koo.spring_data_redis_utilization.otp.dto.OtpVerifyRequestDto;
import koo.spring_data_redis_utilization.otp.repository.OtpRedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OtpRedisService {

    private final OtpRedisRepository otpRedisRepository;

    public String generateOtp(String phoneNumber) {
        String otpNumber = otpRedisRepository.generateOtp(phoneNumber);

        return otpNumber;
    }

    public String verifyOtp(OtpVerifyRequestDto otpVerifyRequestDto) {
        String result = otpRedisRepository.verifyOtp(otpVerifyRequestDto);

        return result;
    }

}
