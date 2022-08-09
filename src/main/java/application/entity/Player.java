package application.entity;

import application.enumerated.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_players")
public class Player { // Classe que representa um jogador da partida.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne()
    private Team team;

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
    }
}
