package koo.spring_data_redis_utilization.fixedWindowRateLimiter.api;

import jakarta.servlet.http.HttpServletRequest;
import koo.spring_data_redis_utilization.fixedWindowRateLimiter.domain.Ip;
import koo.spring_data_redis_utilization.fixedWindowRateLimiter.dto.IpRequestDto;
import koo.spring_data_redis_utilization.fixedWindowRateLimiter.service.RateLimiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Time;
import java.time.LocalTime;

@RestController
@RequiredArgsConstructor
public class IpRestController {

    private final RateLimiterService rateLimiterService;

    @PostMapping("/api/ip")
    public ResponseEntity<String> ipRequest(@RequestBody IpRequestDto ipRequestDto, HttpServletRequest httpServletRequest) {
        String userIp = httpServletRequest.getRemoteAddr();// 서버로 요청한 클라이언트의 ip 가져오기
        log.info();

        Ip ip = new Ip();
        ip.setUserIp(userIp);
        ip.setUserName(ipRequestDto.getUserName());
        ip.setLastRequestTime(LocalTime.now()); // 시/분/초

        Boolean requestEligibility = rateLimiterService.checkRate(ip);

        if (!requestEligibility) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }

        return ResponseEntity.ok("success");
    }

}
