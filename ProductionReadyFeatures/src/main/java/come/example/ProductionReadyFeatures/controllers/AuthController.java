package come.example.ProductionReadyFeatures.controllers;

import come.example.ProductionReadyFeatures.dto.LoginDto;
import come.example.ProductionReadyFeatures.dto.LoginResponseDto;
import come.example.ProductionReadyFeatures.dto.SignUpDto;
import come.example.ProductionReadyFeatures.dto.UserDto;
import come.example.ProductionReadyFeatures.services.AuthService;
import come.example.ProductionReadyFeatures.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class  AuthController {

    private final UserService userService;
    private final AuthService authService;


    @Value("${deploy.Env}")
    private String deployEnv;

   @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
         UserDto userDto = userService.signUp(signUpDto);
         return ResponseEntity.ok(userDto);
   }

    @PostMapping("/login")
   public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response){
       LoginResponseDto loginResponseDto = authService.login(loginDto);


       Cookie cookie = new Cookie("refreshToken",loginResponseDto.getRefreshToken());
       cookie.setHttpOnly(true);
       cookie.setSecure("production".equals(deployEnv));
       response.addCookie(cookie);

       return ResponseEntity.ok(loginResponseDto);
   }

   @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(HttpServletRequest request){
      String refreshToken= Arrays.stream(request.getCookies()).
               filter(cookie -> "refresh token ".equals(cookie.getName()))
               .findFirst()
              .map(Cookie::getValue)
               .orElseThrow(()->new AuthenticationServiceException("Refresh token not found inside the cookies"));
      LoginResponseDto loginResponseDto = authService.refreshToken(refreshToken);
      return ResponseEntity.ok(loginResponseDto);
   }


}
