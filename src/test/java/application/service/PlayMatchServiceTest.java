package application.service;

import application.dto.request.MatchRequestDto;
import application.dto.request.PlayerRequestDto;
import application.dto.response.MatchResponseDto;
import application.dto.response.TeamResponseDto;
import application.enumerated.Position;
import application.service.serviceAction.PlayMatchService;
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
    void quantityPlayersAndNoDrawGoalKeeper() { // Método que testa a quantidade de jogadores distribuida e total, além de testar o metodo do service sem parametro.

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
    void drawGoalKeeperParameterYes() { // Testando o service com o parametro yes

        MatchResponseDto dto = instance("yes");

        boolean conditional = thereIsGoalKeeper(dto.getTeamA(), Position.GOALKEEPER);

        Assertions.assertTrue(conditional);

    }

    @Test
    void drawGoalKeeperParameterNo() { // Testando o service com o parametro no

        MatchResponseDto dto = instance("no");

        boolean conditional = thereIsGoalKeeper(dto.getTeamA(), Position.GOALKEEPER);

        Assertions.assertFalse(conditional);

    }

    @Test
    void invalidParam() { // Testando o service com um parametro inválido

        Assertions.assertThrows(InvalidParamException.class, () -> instance("yesp"));

    }

    private boolean thereIsGoalKeeper(TeamResponseDto team, Position position) {  // Método que retorna um boolean se tal posição foi encontrada em um jogador da lista.
        return team.getPlayers().stream().anyMatch(player -> player.getPosition().equals(position));
    }

    private MatchResponseDto instance(String drawGoalKeeper) { // Método que cria e retorna um MatchDto com os 2 times e jogadores populados.

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
