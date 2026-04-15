package com.mybodyfitness.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN_GERAL")
public class AdminGeral extends Utilizador {

    public AdminGeral() {}
}
