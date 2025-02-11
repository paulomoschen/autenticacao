package br.edu.utfpr.paulo.autenticacao.services;

import br.edu.utfpr.paulo.autenticacao.clients.SeriesClients;
import br.edu.utfpr.paulo.autenticacao.dtos.SerieDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {
    private final SeriesClients serieClient;

    public SerieService(SeriesClients serieClient) {
        this.serieClient = serieClient;
    }

    public List<SerieDTO> buscarSerie() {
        return serieClient.getSeries();
    }

    public SerieDTO criarSerie(SerieDTO serieDTO) {
        return serieClient.criarSerie(serieDTO);
    }

    public String atualizarSerie(Long id, SerieDTO serieDTO) {
        return serieClient.atualizarSerie(id, serieDTO);
    }

    public String deletarSerie(Long id) {
        return serieClient.deletarSerie(id);
    }
}
