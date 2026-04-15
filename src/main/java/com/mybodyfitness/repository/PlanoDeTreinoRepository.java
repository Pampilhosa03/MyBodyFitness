package com.mybodyfitness.repository;

import com.mybodyfitness.model.PlanoDeTreino;
import com.mybodyfitness.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanoDeTreinoRepository extends JpaRepository<PlanoDeTreino, Long> {
    List<PlanoDeTreino> findByCriador(Utilizador criador);
    List<PlanoDeTreino> findByPublicoTrue();
    List<PlanoDeTreino> findByPublicoTrueAndNomeContainingIgnoreCase(String nome);
}
