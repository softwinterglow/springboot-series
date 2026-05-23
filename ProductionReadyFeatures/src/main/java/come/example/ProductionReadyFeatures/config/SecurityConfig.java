package come.example.ProductionReadyFeatures.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//port java.lang.classfile.ClassFile;im

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        Stateless sessions (token-based authentication)
//        Disable CSRF
//        Authorize
        httpSecurity
                .sessionManagement(c->
                        c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf((AbstractHttpConfigurer::disable))
                .authorizeHttpRequests(c->
                        c.requestMatchers("/posts","/carts").permitAll()
                                .requestMatchers("/posts/**").hasAnyRole("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/users").permitAll()
                                .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }

    @Bean
    UserDetailsService myInMemoryUserDetailsService(){
        UserDetails normalUser = User.
                withUsername("anuj")
                .password(passwordEncoder().encode("Eren123"))
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUser, admin);
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }




}
