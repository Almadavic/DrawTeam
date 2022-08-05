package application.dto.response;

import application.entity.Match;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder(value = {"Number Total Players", "Team 1", "Team 2"})
public class MatchResponseDto {  // Dto da entidade Match

    @JsonIgnore
    private Long id;
    @JsonProperty(value = "Number Total Players")
    private int numberPlayers;
    @JsonProperty(value = "Team 1")
    private TeamResponseDto teamA;
    @JsonProperty(value = "Team 2")
    private TeamResponseDto teamB;

    public MatchResponseDto(Match match) {
        this.id = match.getId();
        this.numberPlayers = match.getNumberPlayers();
        this.teamA = new TeamResponseDto(match.getA());
        this.teamB = new TeamResponseDto(match.getB());
    }

}
