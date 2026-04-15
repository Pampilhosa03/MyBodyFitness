package com.mybodyfitness.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medidas")
public class Medida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime data;

    private Double pesoKg;
    private Double alturaCm;
    private Double imc;
    private Double peitoCm;
    private Double cinturaCm;
    private Double ancaCm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilizador_id")
    private Utilizador utilizador;

    public Medida() {}

    public Long getId() { return id; }
    public LocalDateTime getData() { return data; }
    public void setData(LocalDateTime data) { this.data = data; }
    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
    public Double getAlturaCm() { return alturaCm; }
    public void setAlturaCm(Double alturaCm) { this.alturaCm = alturaCm; }
    public Double getImc() { return imc; }
    public void setImc(Double imc) { this.imc = imc; }
    public Double getPeitoCm() { return peitoCm; }
    public void setPeitoCm(Double peitoCm) { this.peitoCm = peitoCm; }
    public Double getCinturaCm() { return cinturaCm; }
    public void setCinturaCm(Double cinturaCm) { this.cinturaCm = cinturaCm; }
    public Double getAncaCm() { return ancaCm; }
    public void setAncaCm(Double ancaCm) { this.ancaCm = ancaCm; }
    public Utilizador getUtilizador() { return utilizador; }
    public void setUtilizador(Utilizador utilizador) { this.utilizador = utilizador; }
}
