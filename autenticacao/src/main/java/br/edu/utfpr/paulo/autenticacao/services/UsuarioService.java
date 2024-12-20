package br.edu.utfpr.paulo.autenticacao.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.edu.utfpr.paulo.autenticacao.model.Usuario;
import br.edu.utfpr.paulo.autenticacao.repositories.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private SerieFeignClient serieFeignClient;

    public Usuario createUsuario(Usuario usuario) {
        validaUsuario(usuario);
        return usuarioRepository.save(usuario);
    }

    private void validaUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já está em uso.");
        }   
    }

    @Value("${jwt.secret}")
    private String jwtSecret;
    
    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    public String login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Email ou senha inválidos."));

        if (!usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Email ou senha inválidos.");
        }

        return gerarToken(usuario);
    }

    private String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("id", usuario.getId())
                .claim("nome", usuario.getNome())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
