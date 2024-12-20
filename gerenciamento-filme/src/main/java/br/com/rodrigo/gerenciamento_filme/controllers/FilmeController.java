package br.com.rodrigo.gerenciamento_filme.controllers;

import br.com.rodrigo.gerenciamento_filme.model.Filme;
import br.com.rodrigo.gerenciamento_filme.repositories.FilmeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    private FilmeRepository filmeRepository;

    public FilmeController(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Filme>> getFilmes() { return ResponseEntity.ok(filmeRepository.findAll()); }

    @PostMapping
    public ResponseEntity<Filme> addOne(@RequestBody Filme filme) {
        if (filme.getTitulo() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(filme);
        } else {
            this.filmeRepository.save(filme);
            return ResponseEntity.status(HttpStatus.CREATED).body(filme);
        }
    }

//    @PutMapping(path = "/{titulo}")
//    public ResponseEntity<String> update(@PathVariable(name="titulo") String titulo, @RequestBody Filme filme) {
//        Filme filmeDB = this.filmeRepository.findByTitulo(titulo).orElse(null);
//        if (filmeDB != null){
//            filmeDB.setTitulo(filme.getTitulo());
//            filmeDB.setGenero(filme.getGenero());
//            filmeDB.setAnoLancamento(filme.getAnoLancamento());
//            filmeDB.setProdutora(filme.getProdutora());
//            this.filmeRepository.save(filmeDB);
//            return ResponseEntity.ok("Filme atualizado com sucesso.");
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
//    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<String> update(@PathVariable(name="id") Long idFilme, @RequestBody Filme filme) {
        Filme filmeDB = this.filmeRepository.findById(idFilme).orElse(null);
        if (filmeDB != null){
            filmeDB.setTitulo(filme.getTitulo());
            filmeDB.setGenero(filme.getGenero());
            filmeDB.setAnoLancamento(filme.getAnoLancamento());
            filmeDB.setProdutora(filme.getProdutora());
            this.filmeRepository.save(filmeDB);
            return ResponseEntity.ok("Filme atualizado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Long idFilme) {
        Filme filmeDB = this.filmeRepository.findById(idFilme).orElse(null);
        if (filmeDB != null){
            this.filmeRepository.delete(filmeDB);
            return ResponseEntity.ok("Filme deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não encontrado.");
    }
}
