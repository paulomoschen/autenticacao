package br.edu.utfpr.paulo.autenticacao.clients;

import br.edu.utfpr.paulo.autenticacao.dtos.SerieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "serie-service", url = "http://localhost:8082")
public interface SeriesClients {

    @GetMapping("/series")
    List<SerieDTO> getSeries();

    @PostMapping("/series")
    SerieDTO criarSerie(@RequestBody SerieDTO serieDTO);

    @PutMapping("/series/{id}")
    String atualizarSerie(@PathVariable Long id, @RequestBody SerieDTO serieDTO);

    @DeleteMapping("/series/{id}")
    String deletarSerie(@PathVariable Long id);
}
