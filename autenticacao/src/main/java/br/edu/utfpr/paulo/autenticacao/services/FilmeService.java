package br.edu.utfpr.paulo.autenticacao.services;

import br.edu.utfpr.paulo.autenticacao.clients.FilmesClients;
import br.edu.utfpr.paulo.autenticacao.dtos.FilmeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    private final FilmesClients filmeClient;

    FilmeService(FilmesClients filmeClient) {
        this.filmeClient = filmeClient;
    }

    public List<FilmeDTO> buscarFilme() {
        return filmeClient.getFilmes();
    }

    public FilmeDTO criarFilme(FilmeDTO filmeDTO) {
        return filmeClient.criarFilme(filmeDTO);
    }

    public String atualizarFilme(Long id, FilmeDTO filmeDTO) {
        return filmeClient.atualizarFilme(id, filmeDTO);
    }

    public String deletarFilme(Long id) {
        return filmeClient.deletarFilme(id);
    }
}
