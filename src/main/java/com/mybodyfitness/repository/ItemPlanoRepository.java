package com.mybodyfitness.repository;

import com.mybodyfitness.model.ItemPlano;
import com.mybodyfitness.model.PlanoDeTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemPlanoRepository extends JpaRepository<ItemPlano, Long> {
    List<ItemPlano> findByPlanoDeTreino(PlanoDeTreino planoDeTreino);
}
