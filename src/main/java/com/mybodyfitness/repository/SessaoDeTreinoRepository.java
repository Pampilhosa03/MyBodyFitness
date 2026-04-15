package com.mybodyfitness.repository;

import com.mybodyfitness.model.SessaoDeTreino;
import com.mybodyfitness.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SessaoDeTreinoRepository extends JpaRepository<SessaoDeTreino, Long> {
    List<SessaoDeTreino> findByUtilizadorOrderByDataDesc(Utilizador utilizador);
    Optional<SessaoDeTreino> findByUtilizadorAndConcluidaFalse(Utilizador utilizador);
}
