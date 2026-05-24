package come.example.ProductionReadyFeatures.config;


import come.example.ProductionReadyFeatures.Filters.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//port java.lang.classfile.ClassFile;im

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

private final JwtAuthFilter jwtAuthFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

//        Stateless sessions (token-based authentication)
//        Disable CSRF
//        Authorize
        httpSecurity
                .sessionManagement(c->
                        c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf((AbstractHttpConfigurer::disable))
                .authorizeHttpRequests(c->
                        c.requestMatchers("/posts","/carts","/auth/**").permitAll()
//                                .requestMatchers("/posts/**").authenticated()
                                .requestMatchers(HttpMethod.POST,"/users").permitAll()
                                .anyRequest().authenticated()

                );
        return httpSecurity.build();
    }

//    @Bean
//    UserDetailsService myInMemoryUserDetailsService(){
//        UserDetails normalUser = User.
//                withUsername("anuj")
//                .password(passwordEncoder().encode("Eren123"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("admin123"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(normalUser, admin);
//    }





    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration conig) throws Exception{
        return conig.getAuthenticationManager();
    }


}
