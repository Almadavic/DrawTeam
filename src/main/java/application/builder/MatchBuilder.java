package application.builder;

import application.entity.Match;
import application.entity.Team;
import lombok.Getter;

@Getter
public class MatchBuilder { // Seta os atributos em um Match de uma maneira mais agradável e legivel.

    private Integer numberPlayers;

    private Team teamA;

    private Team teamB;

    public MatchBuilder setNumberPlayers(int numberPlayers) {
        this.numberPlayers = numberPlayers;
        return this;
    }

    public MatchBuilder setTeamA(Team teamA) {
        this.teamA = teamA;
        return this;
    }

    public MatchBuilder setTeamB(Team teamB) {
        this.teamB = teamB;
        return this;
    }

    public void setAttributes(Match match) {
        match.setA(teamA);
        match.setB(teamB);
        match.setNumberPlayers(numberPlayers);
    }

}
