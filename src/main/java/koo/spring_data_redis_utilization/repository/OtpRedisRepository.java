package koo.spring_data_redis_utilization.repository;

import koo.spring_data_redis_utilization.dto.OtpRequestDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * OTP(One Time Password, 임시비밀번호) 기능을 구현하기 위한 Redis Repository
 * SET 010-1111-1111:otp 123456 EX 300 (key->전화번호:otp, value->임시비밀번호 == 123456, 만료시간은 300초)
 * GET 010-1111-1111:otp
 */
@Repository
@RequiredArgsConstructor
public class OtpRedisRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public String generateOtp(String phoneNumber) {
        String otpNumber = "";
        int oneRandomInt = 0;

        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            oneRandomInt = random.nextInt(10); // 0~9의 랜덤 정수 생성
            otpNumber += Integer.toString(oneRandomInt);
        }

        addOtp(phoneNumber, otpNumber);

        return otpNumber;
    }

    public Long addOtp(String phoneNumber, String otpNumber) {
        return redisTemplate
                .opsForSet() // 중복되는 key를 가진 데이터를 허용하지 않으며 순서가 없는 Redis의 SET 자료구조 이용 (.opsForValue는 String 자료구조를 위한 것임)
                .add(phoneNumber + ":otp", otpNumber.toString());
    }

    public Boolean verifyOtp(OtpRequestDto otpRequestDto) {
        String respondedOtpNumber = redisTemplate
                .opsForSet()
                .pop(otpRequestDto.getPhoneNumber() + ":otp");

        if (respondedOtpNumber != otpRequestDto.getOtpNumber()) {
            return false;
        }

        return true;
    }

}
