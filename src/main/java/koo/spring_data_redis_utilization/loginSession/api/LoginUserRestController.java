package koo.spring_data_redis_utilization.loginSession.api;

import koo.spring_data_redis_utilization.loginSession.domain.dto.RegisterRequestDto;
import koo.spring_data_redis_utilization.loginSession.domain.entity.LoginUser;
import koo.spring_data_redis_utilization.loginSession.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginUserRestController {

    private final PasswordEncoder passwordEncoder;

    private final LoginUserService loginUserService;

    @PostMapping("/api/loginSession/user")
    public void register(RegisterRequestDto registerRequestDto) throws Exception {
        //비밀번호 인코딩 후 회원가입
        LoginUser user = new LoginUser();
        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));

        loginUserService.register(user);
    }

    @PostMapping("/api/loginSession/login/user")
    public LoginUser login(LoginUser userDto) throws Exception {
        if(userDto.getUseremail() == null || userDto.getUserpw() == null)
            return null;
        return userMapper.login(userDto);
        //userInfo에서 가져온 비밀번호(암호화됨)와 지금 입력받은 비밀번호 match 확인
        String encodePw = userMapper.userInfo(userDto.getUseremail()).getUserpw();
        if(passwordEncoder.matches(userDto.getUserpw(),encodePw)) {
            //암호화 된 비밀번호로 pw 정보 변경 후 로그인
            userDto.setUserpw(encodePw);
            return userMapper.login(userDto);
        }else {
            return null;
        }
    }

}
