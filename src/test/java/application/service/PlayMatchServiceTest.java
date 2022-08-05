package application.service;

import application.dto.request.MatchRequestDto;
import application.dto.request.PlayerRequestDto;
import application.dto.response.MatchResponseDto;
import application.dto.response.TeamResponseDto;
import application.enumerated.Position;
import application.service.ServiceAction.PlayMatchService;
import application.service.exception.InvalidParamException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayMatchServiceTest {

    @Autowired
    private PlayMatchService service;


    @Test
    void quantityPlayersAndNoDrawGoalKeeper() {

        MatchResponseDto dto = instance(null);

        TeamResponseDto teamA = dto.getTeamA();
        TeamResponseDto teamB = dto.getTeamB();

        Assertions.assertEquals(4, dto.getNumberPlayers());
        Assertions.assertEquals(2, teamA.getNumberPlayers());
        Assertions.assertEquals(2, teamB.getNumberPlayers());
        Assertions.assertEquals(teamA.getNumberPlayers(), teamA.getPlayers().size());

        boolean conditional = thereIsGoalKeeper(teamA, Position.GOALKEEPER);

        Assertions.assertFalse(conditional);

    }

    @Test
    void drawGoalKeeperParameterYes() {

        MatchResponseDto dto = instance("yes");

        boolean conditional = thereIsGoalKeeper(dto.getTeamA(), Position.GOALKEEPER);

        Assertions.assertTrue(conditional);

    }

    @Test
    void drawGoalKeeperParameterNo() {

        MatchResponseDto dto = instance("no");

        boolean conditional = thereIsGoalKeeper(dto.getTeamA(), Position.GOALKEEPER);

        Assertions.assertFalse(conditional);

    }

    @Test
    void invalidParam() {

        Assertions.assertThrows(InvalidParamException.class, () -> instance("yesp"));

    }

    private boolean thereIsGoalKeeper(TeamResponseDto team, Position position) {
        return team.getPlayers().stream().anyMatch(player -> player.getPosition().equals(position));
    }

    private MatchResponseDto instance(String drawGoalKeeper) {

        MatchRequestDto matchForm = new MatchRequestDto();

        PlayerRequestDto p1 = new PlayerRequestDto("João");
        PlayerRequestDto p2 = new PlayerRequestDto("Gabriel");

        PlayerRequestDto p3 = new PlayerRequestDto("Victor");
        PlayerRequestDto p4 = new PlayerRequestDto("Mateus");

        matchForm.addPlayer(p1);
        matchForm.addPlayer(p2);
        matchForm.addPlayer(p3);
        matchForm.addPlayer(p4);

        MatchResponseDto dto = service.run(matchForm, drawGoalKeeper);

        return dto;
    }

}
