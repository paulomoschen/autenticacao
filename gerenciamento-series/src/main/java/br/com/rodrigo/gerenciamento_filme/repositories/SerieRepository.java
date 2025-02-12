package br.com.rodrigo.gerenciamento_filme.repositories;

import br.com.rodrigo.gerenciamento_filme.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SerieRepository extends JpaRepository<Serie, String> {
    Optional<Serie> findById(Long idSerie);
}
