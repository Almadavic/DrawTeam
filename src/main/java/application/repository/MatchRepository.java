package application.repository;

import application.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> { // Repositorio que faz a ponte entre a aplicação e o banco de dados da classe Match.
}
