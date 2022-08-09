package application.service.serviceAction;

import application.builder.MatchBuilder;
import application.dto.request.MatchRequestDto;
import application.dto.request.PlayerRequestDto;
import application.dto.response.MatchResponseDto;
import application.entity.Match;
import application.entity.Player;
import application.entity.Team;
import application.enumerated.Position;
import application.repository.MatchRepository;
import application.service.businessRule.drawGoalkeeper.DrawGoalkeeperCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class PlayMatchService {

    @Autowired
    private MatchRepository matchRepository; // Repositorio da classe Match.

    @Autowired
    private List<DrawGoalkeeperCheck> validationsDrawGoalkeeper; // Interface para fazer as validações (regras de negócio)

    public MatchResponseDto run(MatchRequestDto matchForm, String drawGoalKeeper) { // Metódo principal ( Cria a partida, os times, salva a partida...)

        Match match = new Match(); // Cria uma partida

        int totalPlayers = matchForm.getPlayers().size(); // Tamanho da lista de jogadores que foi passado no postman
        int halfPlayers = totalPlayers / 2; // o tamanho da metade dessa lista (para dividir para os 2 times).


        Team teamA = new Team('A', halfPlayers, match); // Criando time A

        Team teamB = new Team('B', (totalPlayers - halfPlayers), match); // Criando time B

        List<Player> players = convertFromPlayerFormListToPlayerList(matchForm); // Método para converter a lista.

        assembleTeams(teamA, teamB, players, halfPlayers, drawGoalKeeper); // Método para montar o time.

        new MatchBuilder().                   // Cadeamento de Metódos -> Usado para setar dados nos atributtos da classe Match, de uma forma mais amigável e legivel.
                setNumberPlayers(totalPlayers).
                setTeamA(teamA).
                setTeamB(teamB).
                setAttributes(match);

        match = matchRepository.save(match); // Salva a partida (match) no banco.

        return new MatchResponseDto(match); // Me retorna um DTO da partida (match).
    }

    private List<Player> convertFromPlayerFormListToPlayerList(MatchRequestDto matchForm) { // converte a lista do request (matchForm) de players e cria  uma lista da entidade Players
        List<Player> players = new ArrayList<>();                                    // Sorteia essa lista criada(posição dos players) e devolve essa lista sortiada.
        for (PlayerRequestDto player : matchForm.getPlayers()) {
            String name = player.getName();
            Player newPlayer = new Player(name, Position.LINE);
            players.add(newPlayer);
        }
        Collections.shuffle(players);
        return players;
    }

    private void assembleTeams(Team teamA, Team teamB, List<Player> players, int halfPlayers, String drawGoalkeeper) { // Pega a lista de players, os 2 times, a metade da quantidade de jogadores e o parametro dramGoalKeeper.
        // A lista de players, a metade dos alunos dessa lista, vão para o time A e a outra metade para o B.
        // O parametro do drawGoalkepper é para saber se o goleira vai ser sorteado.
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (i < halfPlayers) {
                setTeam(teamA, player);              // Da linha 72 até a 78 é a logica para passar os jogadores para os 2 times.
            } else {
                setTeam(teamB, player);
            }
        }
        if (drawGoalkeeper != null && !drawGoalkeeper.equalsIgnoreCase("NO")) {   // Vai entrar na condição se o parametro for diferente de não e nulo.
            validationsDrawGoalkeeper.forEach(v -> v.validation(drawGoalkeeper));  // Aqui verifica se o parametro é yes ou se é outra coisa, se for outra coisa, vai dar erro.
            drawGoalkeeper(teamA); // Chamada o método de sortear um goleiro para o time A
            drawGoalkeeper(teamB); // E para o time B.
        }
    }

    private void setTeam(Team team, Player player) { // Esse método seta um player em um time e um time em um player
        player.setTeam(team);
        team.addPlayer(player);
    }

    private void drawGoalkeeper(Team team) {   // É passado um time, o método pega a lista de jogadores do time, pega uma posição aleatoria e
        int size = team.getNumberPlayers();   // e denomina ela como a posião do goleiro.
        Random generate = new Random();
        int random = generate.nextInt(size);
        Player player = team.getPlayers().get(random);
        player.setPosition(Position.GOALKEEPER);
    }

}
