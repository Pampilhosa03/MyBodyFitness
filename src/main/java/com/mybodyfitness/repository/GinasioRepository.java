package com.mybodyfitness.repository;

import com.mybodyfitness.model.Ginasio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GinasioRepository extends JpaRepository<Ginasio, Long> {
    List<Ginasio> findByAtivoTrue();
    List<Ginasio> findByNomeContainingIgnoreCase(String nome);
}
