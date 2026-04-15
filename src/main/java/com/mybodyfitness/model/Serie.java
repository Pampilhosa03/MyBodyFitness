package com.mybodyfitness.model;

import jakarta.persistence.*;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ordemNaSessao;

    private Double cargaKg;

    @Column(nullable = false)
    private int repeticoes;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sessao_id")
    private SessaoDeTreino sessaoDeTreino;

    @ManyToOne(optional = false)
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

    public Serie() {}

    public Long getId() { return id; }
    public int getOrdemNaSessao() { return ordemNaSessao; }
    public void setOrdemNaSessao(int ordemNaSessao) { this.ordemNaSessao = ordemNaSessao; }
    public Double getCargaKg() { return cargaKg; }
    public void setCargaKg(Double cargaKg) { this.cargaKg = cargaKg; }
    public int getRepeticoes() { return repeticoes; }
    public void setRepeticoes(int repeticoes) { this.repeticoes = repeticoes; }
    public SessaoDeTreino getSessaoDeTreino() { return sessaoDeTreino; }
    public void setSessaoDeTreino(SessaoDeTreino sessaoDeTreino) { this.sessaoDeTreino = sessaoDeTreino; }
    public Exercicio getExercicio() { return exercicio; }
    public void setExercicio(Exercicio exercicio) { this.exercicio = exercicio; }
}
