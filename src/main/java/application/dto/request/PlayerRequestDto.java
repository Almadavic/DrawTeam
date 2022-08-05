package application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequestDto { // Representa o nome do player que será passado no postman.

    @NotBlank
    private String name;

}
