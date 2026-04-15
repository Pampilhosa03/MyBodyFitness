package com.mybodyfitness.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sessoes_treino")
public class SessaoDeTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    private Integer duracaoMin;
    private String notas;
    private boolean concluida = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilizador_id")
    private Utilizador utilizador;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private PlanoDeTreino planoDeTreino;

    @ManyToOne
    @JoinColumn(name = "ginasio_id")
    private Ginasio ginasio;

    @OneToMany(mappedBy = "sessaoDeTreino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Serie> series = new ArrayList<>();

    public SessaoDeTreino() {}

    public Long getId() { return id; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
    public Integer getDuracaoMin() { return duracaoMin; }
    public void setDuracaoMin(Integer duracaoMin) { this.duracaoMin = duracaoMin; }
    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
    public boolean isConcluida() { return concluida; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }
    public Utilizador getUtilizador() { return utilizador; }
    public void setUtilizador(Utilizador utilizador) { this.utilizador = utilizador; }
    public PlanoDeTreino getPlanoDeTreino() { return planoDeTreino; }
    public void setPlanoDeTreino(PlanoDeTreino planoDeTreino) { this.planoDeTreino = planoDeTreino; }
    public Ginasio getGinasio() { return ginasio; }
    public void setGinasio(Ginasio ginasio) { this.ginasio = ginasio; }
    public List<Serie> getSeries() { return series; }
}
