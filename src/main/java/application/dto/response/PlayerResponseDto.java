package application.dto.response;

import application.entity.Player;
import application.enumerated.Position;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonPropertyOrder(value = {"Letter", "Number Players Team", "Players"})
public class PlayerResponseDto { // DTO da entidade Player (Response).

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "Position")
    private Position position;

    public PlayerResponseDto(Player player) {
        this.name = player.getName();
        this.position = player.getPosition();
    }

}
