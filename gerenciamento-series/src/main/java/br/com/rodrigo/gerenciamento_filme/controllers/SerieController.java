package br.com.rodrigo.gerenciamento_filme.controllers;

import br.com.rodrigo.gerenciamento_filme.model.Serie;
import br.com.rodrigo.gerenciamento_filme.repositories.SerieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {
    private SerieRepository serieRepository;

    public SerieController(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @GetMapping
    public ResponseEntity<List<Serie>> getFilmes() { return ResponseEntity.ok(serieRepository.findAll()); }

    @PostMapping
    public ResponseEntity<Serie> addOne(@RequestBody Serie serie) {
        if (serie.getTitulo() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(serie);
        } else {
            this.serieRepository.save(serie);
            return ResponseEntity.status(HttpStatus.CREATED).body(serie);
        }
    }

//    @PutMapping(path = "/{titulo}")
//    public ResponseEntity<String> update(@PathVariable(name="titulo") String titulo, @RequestBody Serie filme) {
//        Serie filmeDB = this.serieRepository.findByTitulo(titulo).orElse(null);
//        if (filmeDB != null){
//            filmeDB.setTitulo(filme.getTitulo());
//            filmeDB.setGenero(filme.getGenero());
//            filmeDB.setAnoLancamento(filme.getAnoLancamento());
//            filmeDB.setProdutora(filme.getProdutora());
//            this.serieRepository.save(filmeDB);
//            return ResponseEntity.ok("Serie atualizado com sucesso.");
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serie não encontrado.");
//    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<String> update(@PathVariable(name="id") Long idSerie, @RequestBody Serie serie) {
        Serie serieDB = this.serieRepository.findById(idSerie).orElse(null);
        if (serieDB != null){
            serieDB.setTitulo(serie.getTitulo());
            serieDB.setTemporada(serie.getTemporada());
            serieDB.setEpisodio(serie.getEpisodio());
            serieDB.setGenero(serie.getGenero());
            serieDB.setAnoLancamento(serie.getAnoLancamento());
            serieDB.setProdutora(serie.getProdutora());
            this.serieRepository.save(serieDB);
            return ResponseEntity.ok("Serie atualizada com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serie não encontrada.");
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name="id") Long idSerie) {
        Serie serieDB = this.serieRepository.findById(idSerie).orElse(null);
        if (serieDB != null){
            this.serieRepository.delete(serieDB);
            return ResponseEntity.ok("Serie deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Serie não encontrado.");
    }
}