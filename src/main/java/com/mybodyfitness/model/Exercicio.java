package com.mybodyfitness.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private String grupoMuscular;

    @ManyToMany
    @JoinTable(
        name = "exercicio_equipamento",
        joinColumns = @JoinColumn(name = "exercicio_id"),
        inverseJoinColumns = @JoinColumn(name = "equipamento_id")
    )
    private List<Equipamento> equipamentosNecessarios = new ArrayList<>();

    public Exercicio() {}

    public Exercicio(String nome, String descricao, String grupoMuscular) {
        this.nome = nome;
        this.descricao = descricao;
        this.grupoMuscular = grupoMuscular;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }
    public List<Equipamento> getEquipamentosNecessarios() { return equipamentosNecessarios; }
    public void setEquipamentosNecessarios(List<Equipamento> equipamentosNecessarios) {
        this.equipamentosNecessarios = equipamentosNecessarios;
    }
}
