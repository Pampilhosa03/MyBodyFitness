package com.mybodyfitness.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ginasios")
public class Ginasio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String morada;

    private boolean ativo = true;

    @ManyToMany
    @JoinTable(
        name = "ginasio_equipamento",
        joinColumns = @JoinColumn(name = "ginasio_id"),
        inverseJoinColumns = @JoinColumn(name = "equipamento_id")
    )
    private List<Equipamento> equipamentosDisponiveis = new ArrayList<>();

    @OneToOne(mappedBy = "ginasio")
    private AdminLocal adminLocal;

    public Ginasio() {}

    public Ginasio(String nome, String morada) {
        this.nome = nome;
        this.morada = morada;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getMorada() { return morada; }
    public void setMorada(String morada) { this.morada = morada; }
    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public List<Equipamento> getEquipamentosDisponiveis() { return equipamentosDisponiveis; }
    public void setEquipamentosDisponiveis(List<Equipamento> equipamentosDisponiveis) {
        this.equipamentosDisponiveis = equipamentosDisponiveis;
    }
    public AdminLocal getAdminLocal() { return adminLocal; }
}
