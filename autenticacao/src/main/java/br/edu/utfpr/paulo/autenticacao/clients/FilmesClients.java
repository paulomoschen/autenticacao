package br.edu.utfpr.paulo.autenticacao.clients;

import br.edu.utfpr.paulo.autenticacao.dtos.FilmeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "filme-service", url = "http://localhost:8081")
public interface FilmesClients {

    @GetMapping("/filmes")
    List<FilmeDTO> getFilmes();

    @PostMapping("/filmes")
    FilmeDTO criarFilme(@RequestBody FilmeDTO filmeDTO);

    @PutMapping("/filmes/{id}")
    String atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO);

    @DeleteMapping(value = "/filmes/{id}")
    String deletarFilme(@PathVariable Long id);
}
