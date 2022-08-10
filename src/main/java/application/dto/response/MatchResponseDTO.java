package application.dto.response;

import application.entity.Match;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder(value = {"Number Total Players", "Team 1", "Team 2"})
public class MatchResponseDTO {  // Dto da entidade Match (Response).

    @JsonIgnore
    private Long id;
    @JsonProperty(value = "Number Total Players")
    private int numberPlayers;
    @JsonProperty(value = "Team 1")
    private TeamResponseDTO teamA;
    @JsonProperty(value = "Team 2")
    private TeamResponseDTO teamB;

    public MatchResponseDTO(Match match) {
        this.id = match.getId();
        this.numberPlayers = match.getNumberPlayers();
        this.teamA = new TeamResponseDTO(match.getA());
        this.teamB = new TeamResponseDTO(match.getB());
    }

}
