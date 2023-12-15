package Daniel.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Rivista extends Catalogo{

    @Column(name = "Periodicità")
    @Enumerated(EnumType.STRING)
    private Periodicità periodicita;


    public Rivista() {
    }

    public Rivista(String titolo, LocalDate anno_di_pubblicazione, int numero_pagine, Periodicità periodicita) {
        this.titolo = titolo;
        this.anno_di_pubblicazione = anno_di_pubblicazione;
        this.numero_pagine = numero_pagine;
        this.periodicita = periodicita;

    }

    public Periodicità getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicità periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                ", titolo='" + titolo + '\'' +
                ", anno_di_pubblicazione=" + anno_di_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
