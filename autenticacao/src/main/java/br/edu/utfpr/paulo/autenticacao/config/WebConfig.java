package br.edu.utfpr.paulo.autenticacao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class WebConfig {
    @Autowired
    private JwtInterceptor jwtInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // Adicionar o interceptor às rotas que precisam de proteção
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/dados/**"); // Apenas proteger a rota "/dados/**"
    }
}
