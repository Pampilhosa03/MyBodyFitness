package com.mybodyfitness.model;

import jakarta.persistence.*;

// Representa um exercício dentro de um PlanoDeTreino, com o número de séries planeadas
@Entity
@Table(name = "itens_plano")
public class ItemPlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plano_id")
    private PlanoDeTreino planoDeTreino;

    @ManyToOne(optional = false)
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

    @Column(nullable = false)
    private int numSeries;

    public ItemPlano() {}

    public ItemPlano(PlanoDeTreino planoDeTreino, Exercicio exercicio, int numSeries) {
        this.planoDeTreino = planoDeTreino;
        this.exercicio = exercicio;
        this.numSeries = numSeries;
    }

    public Long getId() { return id; }
    public PlanoDeTreino getPlanoDeTreino() { return planoDeTreino; }
    public void setPlanoDeTreino(PlanoDeTreino planoDeTreino) { this.planoDeTreino = planoDeTreino; }
    public Exercicio getExercicio() { return exercicio; }
    public void setExercicio(Exercicio exercicio) { this.exercicio = exercicio; }
    public int getNumSeries() { return numSeries; }
    public void setNumSeries(int numSeries) { this.numSeries = numSeries; }
}
