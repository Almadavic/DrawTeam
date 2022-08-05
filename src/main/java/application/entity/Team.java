package application.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_teams")
public class Team {  // Classe que representa 1 time da partida.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Character letter;

    private Integer numberPlayers;

    @OneToOne()
    private Match match;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private final List<Player> players = new ArrayList<>();

    public Team(Character letter, Integer numberPlayers, Match match) {
        this.letter = letter;
        this.numberPlayers = numberPlayers;
        this.match = match;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
