package application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequestDTO { // Representa o nome do player que será passado no postman (Request).

    @NotBlank
    private String name;

}
