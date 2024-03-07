package koo.spring_data_redis_utilization.service;

import koo.spring_data_redis_utilization.dto.OtpRequestDto;
import koo.spring_data_redis_utilization.repository.OtpRedisRepository;
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

    public Boolean verifyOtp(OtpRequestDto otpRequestDto) {
        Boolean result = otpRedisRepository.verifyOtp(otpRequestDto);

        return result;
    }

}
