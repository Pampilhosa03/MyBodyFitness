package com.mybodyfitness.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planos_treino")
public class PlanoDeTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    private boolean publico = false;

    private LocalDate dataCriacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "criador_id")
    private Utilizador criador;

    @OneToMany(mappedBy = "planoDeTreino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPlano> itens = new ArrayList<>();

    @ManyToMany(mappedBy = "planosSeguidos")
    private List<Utilizador> seguidores = new ArrayList<>();

    public PlanoDeTreino() {}

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public boolean isPublico() { return publico; }
    public void setPublico(boolean publico) { this.publico = publico; }
    public LocalDate getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }
    public Utilizador getCriador() { return criador; }
    public void setCriador(Utilizador criador) { this.criador = criador; }
    public List<ItemPlano> getItens() { return itens; }
    public List<Utilizador> getSeguidores() { return seguidores; }
}
