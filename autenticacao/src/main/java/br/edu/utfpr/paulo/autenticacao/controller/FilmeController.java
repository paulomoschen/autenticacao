package br.edu.utfpr.paulo.autenticacao.controller;

import br.edu.utfpr.paulo.autenticacao.dtos.FilmeDTO;
import br.edu.utfpr.paulo.autenticacao.services.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> obterFilme() {
        return ResponseEntity.ok(filmeService.buscarFilme());
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> criarFilme(@RequestBody FilmeDTO filmeDTO) {
        FilmeDTO novofilme = filmeService.criarFilme(filmeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novofilme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFilme(@PathVariable Long id, @RequestBody FilmeDTO filmeDTO) {
        String filmeAtualizado = filmeService.atualizarFilme(id, filmeDTO);
        return ResponseEntity.ok(filmeAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFilme(@PathVariable Long id) {
        String filmeDeletada = filmeService.deletarFilme(id);
        return ResponseEntity.ok(filmeDeletada);
    }
}
