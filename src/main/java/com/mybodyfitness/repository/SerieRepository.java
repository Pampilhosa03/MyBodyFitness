package com.mybodyfitness.repository;

import com.mybodyfitness.model.Serie;
import com.mybodyfitness.model.SessaoDeTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findBySessaoDeTreino(SessaoDeTreino sessaoDeTreino);
}
