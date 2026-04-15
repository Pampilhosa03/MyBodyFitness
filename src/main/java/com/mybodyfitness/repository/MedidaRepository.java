package com.mybodyfitness.repository;

import com.mybodyfitness.model.Medida;
import com.mybodyfitness.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedidaRepository extends JpaRepository<Medida, Long> {
    List<Medida> findByUtilizadorOrderByDataDesc(Utilizador utilizador);
    long countByUtilizador(Utilizador utilizador);
}
