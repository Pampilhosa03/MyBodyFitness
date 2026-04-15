package com.mybodyfitness.config;

import com.mybodyfitness.model.*;
import com.mybodyfitness.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;

// Carrega dados de teste na BD ao arrancar a aplicação
@Component
public class DataLoader implements CommandLineRunner {

    private final UtilizadorRepository utilizadorRepo;
    private final ExercicioRepository exercicioRepo;
    private final GinasioRepository ginasioRepo;
    private final EquipamentoRepository equipamentoRepo;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UtilizadorRepository u, ExercicioRepository e,
                      GinasioRepository g, EquipamentoRepository eq,
                      PasswordEncoder p) {
        this.utilizadorRepo = u;
        this.exercicioRepo = e;
        this.ginasioRepo = g;
        this.equipamentoRepo = eq;
        this.passwordEncoder = p;
    }

    @Override
    public void run(String... args) {
        if (utilizadorRepo.count() > 0) return; // já inicializado

        // --- Equipamentos ---
        Equipamento barraOlimpica   = equipamentoRepo.save(new Equipamento("Barra Olímpica", "Barra"));
        Equipamento bancoDeSup      = equipamentoRepo.save(new Equipamento("Banco de Supino", "Banco"));
        Equipamento caboLat         = equipamentoRepo.save(new Equipamento("Cabo Lat", "Máquina"));
        Equipamento halteres        = equipamentoRepo.save(new Equipamento("Halteres", "Peso Livre"));
        Equipamento maqLegPress     = equipamentoRepo.save(new Equipamento("Máquina de Leg Press", "Máquina"));
        Equipamento barraFixa       = equipamentoRepo.save(new Equipamento("Barra Fixa", "Estrutura"));

        // --- Ginásios ---
        Ginasio g1 = new Ginasio("Ginásio Fitness Plus", "Rua das Flores 10, Lisboa");
        g1.setEquipamentosDisponiveis(List.of(barraOlimpica, bancoDeSup, caboLat, halteres));
        ginasioRepo.save(g1);

        Ginasio g2 = new Ginasio("Health Club Porto", "Av. da Boavista 200, Porto");
        g2.setEquipamentosDisponiveis(List.of(barraOlimpica, halteres, maqLegPress, barraFixa));
        ginasioRepo.save(g2);

        // --- Exercícios ---
        Exercicio supino = new Exercicio("Supino Plano", "Exercício composto para o peito", "Peito");
        supino.setEquipamentosNecessarios(List.of(barraOlimpica, bancoDeSup));
        exercicioRepo.save(supino);

        Exercicio pulldown = new Exercicio("Pulldown no Cabo", "Exercício para as costas em máquina de cabo", "Costas");
        pulldown.setEquipamentosNecessarios(List.of(caboLat));
        exercicioRepo.save(pulldown);

        Exercicio pullUp = new Exercicio("Pullup (Barra Fixa)", "Exercício para as costas com peso corporal", "Costas");
        pullUp.setEquipamentosNecessarios(List.of(barraFixa));
        exercicioRepo.save(pullUp);

        Exercicio agachamento = new Exercicio("Agachamento com Barra", "Exercício composto para pernas", "Pernas");
        agachamento.setEquipamentosNecessarios(List.of(barraOlimpica));
        exercicioRepo.save(agachamento);

        Exercicio legPress = new Exercicio("Leg Press", "Exercício para as pernas em máquina", "Pernas");
        legPress.setEquipamentosNecessarios(List.of(maqLegPress));
        exercicioRepo.save(legPress);

        Exercicio rosca = new Exercicio("Rosca Bíceps com Halteres", "Isolamento do bíceps", "Braços");
        rosca.setEquipamentosNecessarios(List.of(halteres));
        exercicioRepo.save(rosca);

        Exercicio desenvolvimento = new Exercicio("Desenvolvimento com Halteres", "Exercício para os ombros", "Ombros");
        desenvolvimento.setEquipamentosNecessarios(List.of(halteres));
        exercicioRepo.save(desenvolvimento);

        // --- Utilizador de teste ---
        // Login: joao@test.com / password123
        Utilizador joao = new Utilizador("João Silva", "joao@test.com",
            passwordEncoder.encode("password123"));
        utilizadorRepo.save(joao);

        System.out.println("=== Dados de teste carregados ===");
        System.out.println("Login de teste: joao@test.com / password123");
        System.out.println("H2 Console: http://localhost:8080/h2-console");
    }
}
