package come.example.ProductionReadyFeatures.services;

import come.example.ProductionReadyFeatures.Exceptions.ResourceNotFoundException;

import come.example.ProductionReadyFeatures.dto.SignUpDto;
import come.example.ProductionReadyFeatures.dto.UserDto;
import come.example.ProductionReadyFeatures.entities.User;
import come.example.ProductionReadyFeatures.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(()-> new BadCredentialsException("user not found with this email "+ username));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user not found with this id "+ userId));
    }

    public UserDto signUp(SignUpDto signUpDto) {
      Optional<User> user =userRepository.findByEmail(signUpDto.getEmail());
      if(user.isPresent()){
          throw new BadCredentialsException("User with email already exist "+signUpDto.getEmail());
      }
      User toBeCreatedUser = modelMapper.map(signUpDto, User.class);
      toBeCreatedUser.setPassword(passwordEncoder.encode(toBeCreatedUser.getPassword()));
      User savedUser = userRepository.save(toBeCreatedUser);
      return modelMapper.map(savedUser, UserDto.class);



    }


}
