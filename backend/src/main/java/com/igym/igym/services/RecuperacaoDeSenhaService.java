package com.igym.igym.services;

import com.igym.igym.model.TokenRecuperacao;
import com.igym.igym.model.Usuario;
import com.igym.igym.repositories.TokenRecuperacaoRepository;
import com.igym.igym.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecuperacaoDeSenhaService {
    private final UsuarioRepository usuarioRepository;
    private final TokenRecuperacaoRepository tokenRecuperacaoRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public void solicitarRecuperacao(String email){
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email nao encontrado."));

        String token = UUID.randomUUID().toString();

        TokenRecuperacao tokenRecuperacao = new TokenRecuperacao();
        tokenRecuperacao.setToken(token);
        tokenRecuperacao.setUsuario(usuario);
        tokenRecuperacao.setExpiracao(LocalDateTime.now().plusMinutes(30));
        tokenRecuperacao.setTokenUtilizado(false);
        tokenRecuperacaoRepository.save(tokenRecuperacao);

        emailService.enviarEmailDeRecuperacao(email, token);
    }

    public void redefinirSenha(String token, String novaSenha){
        TokenRecuperacao tokenRecuperacao = tokenRecuperacaoRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token invalido."));

        if(tokenRecuperacao.isTokenUtilizado()){
            throw  new RuntimeException("Token ja utilizado.");
        }
        if(tokenRecuperacao.getExpiracao().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Token ja expirado.");
        }
        Usuario usuario = tokenRecuperacao.getUsuario();
        usuario.setSenha(passwordEncoder.encode(novaSenha));
        usuarioRepository.save(usuario);

        tokenRecuperacao.setTokenUtilizado(true);
        tokenRecuperacaoRepository.save(tokenRecuperacao);
    }
}
