package br.edu.utfpr.paulo.autenticacao.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.utfpr.paulo.autenticacao.dtos.SerieDTO;

@FeignClient(name="api-produto", url="localhost:8080")
public interface SerieFeignClient {

    @GetMapping("/produtos/{id}")
    SerieDTO getProdutoById(@PathVariable Long id);

    
} 