package come.example.ProductionReadyFeatures.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {

    @Email
    private String email;

    private String name;
    private String password;

}
