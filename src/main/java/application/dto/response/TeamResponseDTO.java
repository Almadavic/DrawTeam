package application.dto.response;

import application.entity.Player;
import application.entity.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@JsonPropertyOrder(value = {"Letter", "Number Players Team", "Players"})
public class TeamResponseDTO { // Dto da entidade Team (Response).

    @JsonProperty(value = "Letter")
    private Character letter;

    @JsonProperty(value = "Number Players Team")
    private int numberPlayers;

    @JsonProperty(value = "Players")
    private List<PlayerResponseDTO> players;

    public TeamResponseDTO(Team team) {
        this.letter = team.getLetter();
        this.numberPlayers = team.getNumberPlayers();
        this.players = convertTo(team.getPlayers());
    }

    private List<PlayerResponseDTO> convertTo(List<Player> players) {
        return players.stream().map(PlayerResponseDTO::new).collect(Collectors.toList());
    }

}
