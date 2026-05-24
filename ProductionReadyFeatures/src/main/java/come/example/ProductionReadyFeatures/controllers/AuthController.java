package come.example.ProductionReadyFeatures.controllers;

import come.example.ProductionReadyFeatures.dto.LoginDto;
import come.example.ProductionReadyFeatures.dto.SignUpDto;
import come.example.ProductionReadyFeatures.dto.UserDto;
import come.example.ProductionReadyFeatures.services.AuthService;
import come.example.ProductionReadyFeatures.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class  AuthController {

    private final UserService userService;
    private final AuthService authService;

   @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
         UserDto userDto = userService.signUp(signUpDto);
         return ResponseEntity.ok(userDto);
   }

    @PostMapping("/login")
   public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpServletRequest request, HttpServletResponse response){
       String token = authService.login(loginDto);


       Cookie cookie = new Cookie("token",token);
       cookie.setHttpOnly(true);
       response.addCookie(cookie);

       return ResponseEntity.ok(token);
   }

}
