package com.igym.igym.repositories;

import com.igym.igym.model.TokenRecuperacao;
import org.antlr.v4.runtime.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRecuperacaoRepository extends JpaRepository<TokenRecuperacao, Long> {
    Optional<TokenRecuperacao> findByToken(String token);
}
