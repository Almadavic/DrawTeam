package application.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_match")
public class Match { // Entidade principal, é a partida.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberPlayers;

    @OneToOne(mappedBy = "match", cascade = CascadeType.ALL)
    private Team a;

    @OneToOne(mappedBy = "match", cascade = CascadeType.ALL)
    private Team b;


}
