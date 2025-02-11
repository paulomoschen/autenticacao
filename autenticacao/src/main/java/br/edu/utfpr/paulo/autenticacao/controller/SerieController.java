package br.edu.utfpr.paulo.autenticacao.controller;

import br.edu.utfpr.paulo.autenticacao.dtos.SerieDTO;
import br.edu.utfpr.paulo.autenticacao.services.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public ResponseEntity<List<SerieDTO>> obterSerie() {
        return ResponseEntity.ok(serieService.buscarSerie());
    }

    @PostMapping
    public ResponseEntity<SerieDTO> criarSerie(@RequestBody SerieDTO serieDTO) {
        SerieDTO novaSerie = serieService.criarSerie(serieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarSerie(@PathVariable Long id, @RequestBody SerieDTO serieDTO) {
        String serieAtualizada = serieService.atualizarSerie(id, serieDTO);
        return ResponseEntity.ok(serieAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarSerie(@PathVariable Long id) {
        String serieDeletada = serieService.deletarSerie(id);
        return ResponseEntity.ok(serieDeletada);
    }
}
