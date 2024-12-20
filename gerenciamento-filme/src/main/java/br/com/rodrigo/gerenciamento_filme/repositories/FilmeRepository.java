package br.com.rodrigo.gerenciamento_filme.repositories;

import br.com.rodrigo.gerenciamento_filme.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, String> {
    Optional<Filme> findById(Long idFilme);
    Optional<Filme> findByTitulo(String titulo);

}
