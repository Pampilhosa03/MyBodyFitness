package com.mybodyfitness.repository;

import com.mybodyfitness.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    List<Exercicio> findByGrupoMuscular(String grupoMuscular);
    List<Exercicio> findByNomeContainingIgnoreCase(String nome);
    List<Exercicio> findByGrupoMuscularAndIdNot(String grupoMuscular, Long id);
}
