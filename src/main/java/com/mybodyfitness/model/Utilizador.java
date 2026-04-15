package com.mybodyfitness.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilizadores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CLIENTE")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // Campo auxiliar para ler o discriminador (só leitura)
    @Column(name = "tipo", insertable = false, updatable = false)
    private String tipo;

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.ALL)
    private List<Medida> medidas = new ArrayList<>();

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.ALL)
    private List<SessaoDeTreino> sessoes = new ArrayList<>();

    @OneToMany(mappedBy = "criador", cascade = CascadeType.ALL)
    private List<PlanoDeTreino> planosCriados = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "utilizador_planos_seguidos",
        joinColumns = @JoinColumn(name = "utilizador_id"),
        inverseJoinColumns = @JoinColumn(name = "plano_id")
    )
    private List<PlanoDeTreino> planosSeguidos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "utilizador_ginasios",
        joinColumns = @JoinColumn(name = "utilizador_id"),
        inverseJoinColumns = @JoinColumn(name = "ginasio_id")
    )
    private List<Ginasio> ginasiosPreferidos = new ArrayList<>();

    public Utilizador() {}

    public Utilizador(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getTipo() { return tipo; }
    public List<Medida> getMedidas() { return medidas; }
    public List<SessaoDeTreino> getSessoes() { return sessoes; }
    public List<PlanoDeTreino> getPlanosCriados() { return planosCriados; }
    public List<PlanoDeTreino> getPlanosSeguidos() { return planosSeguidos; }
    public List<Ginasio> getGinasiosPreferidos() { return ginasiosPreferidos; }
    public void setGinasiosPreferidos(List<Ginasio> ginasiosPreferidos) {
        this.ginasiosPreferidos = ginasiosPreferidos;
    }
}
