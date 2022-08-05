package application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class MatchRequestDto { // Representa a partida ( um conjunto de players) passados no postman (Request).

    @Valid
    private List<PlayerRequestDto> players = new ArrayList<>();

    public void addPlayer(PlayerRequestDto player) {
        players.add(player);
    }

}
