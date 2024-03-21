package koo.spring_data_redis_utilization.loginSession.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import koo.spring_data_redis_utilization.loginSession.domain.SessionConst;
import koo.spring_data_redis_utilization.loginSession.domain.dto.LoginRequestDto;
import koo.spring_data_redis_utilization.loginSession.domain.dto.RegisterRequestDto;
import koo.spring_data_redis_utilization.loginSession.domain.entity.LoginUser;
import koo.spring_data_redis_utilization.loginSession.service.LoginUserService;
import koo.spring_data_redis_utilization.snsActivityFeed.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginUserRestController {

    private final PasswordEncoder passwordEncoder;

    private final LoginUserService loginUserService;

    @PostMapping("/api/loginSession/register/user")
    public void register(RegisterRequestDto registerRequestDto) throws Exception {
        //비밀번호 인코딩 후 회원가입
        LoginUser user = new LoginUser();
        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));

        loginUserService.register(user);
    }

    @PostMapping("/api/loginSession/login/user")
    public ResponseEntity<String> login(HttpServletResponse response, LoginRequestDto loginRequestDto) throws Exception {
        if(loginRequestDto.getUsername() == null || loginRequestDto.getPassword() == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        // DB에서 가져온 비밀번호(암호화됨)와 지금 입력받은 비밀번호간의 match 확인
        LoginUser loginUser = loginUserService.findByUsername(loginRequestDto.getUsername()).orElseThrow();

        if(loginUser != null && passwordEncoder.matches(loginRequestDto.getPassword(), loginUser.getPassword())) { // raw password와 encoded password 비교
            loginUserService.setLoginSessionWithHash(response, loginUser);

            return ResponseEntity.ok("success");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/api/loginSession/home")
    public Boolean home(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) String session) { // login 하지 않은 유저도 있을 수 있으므로 required = false 설정
        loginUserService.checkLoginSessionWithHash(loginUser, session);
    }

}
