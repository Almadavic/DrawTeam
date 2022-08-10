package application.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class MatchRequestDTO { // Representa a partida ( um conjunto de players) passados no postman (Request).

    @Valid
    private List<PlayerRequestDTO> players = new ArrayList<>();

    public void addPlayer(PlayerRequestDTO player) {
        players.add(player);
    }

}
