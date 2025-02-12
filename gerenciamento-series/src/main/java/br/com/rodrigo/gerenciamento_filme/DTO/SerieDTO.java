package br.com.rodrigo.gerenciamento_filme.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SerieDTO(
        Long id,

        @NotBlank(message = "O título não pode estar vazio")
        @Size(min = 1, max = 100, message = "O título deve ter entre 2 e 100 caracteres")
        String titulo,

        @Min(value = 1, message = "A temporada deve ser no mínimo 1")
        @Max(value = 50, message = "A temporada deve ser no máximo 50")
        int temporada,

        @Min(value = 1, message = "O episódio deve ser no mínimo 1")
        @Max(value = 1000, message = "O episódio deve ser no máximo 1000")
        int episodio,

        @Min(value = 1888, message = "O ano de lançamento deve ser a partir de 1888")
        // Primeiro filme criado
        @Max(value = 2100, message = "O ano de lançamento deve ser menor que 2100")
        int anoLancamento,

        @NotBlank(message = "O gênero não pode estar vazio")
        @Size(min = 3, max = 50, message = "O gênero deve ter entre 3 e 50 caracteres")
        String genero,

        @NotBlank(message = "A produtora não pode estar vazia")
        @Size(min = 2, max = 100, message = "A produtora deve ter entre 2 e 100 caracteres")
        String produtora) {
}
