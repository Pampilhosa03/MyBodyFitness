package com.mybodyfitness.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN_LOCAL")
public class AdminLocal extends Utilizador {

    @OneToOne
    @JoinColumn(name = "ginasio_id")
    private Ginasio ginasio;

    public AdminLocal() {}

    public Ginasio getGinasio() { return ginasio; }
    public void setGinasio(Ginasio ginasio) { this.ginasio = ginasio; }
}
