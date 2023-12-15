package Daniel.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Rivista")
public class Rivista {
    @Id
    @GeneratedValue
    private UUID codice_isbn;

    @Column(name = "Titolo")
    private String titolo;

    @Column(name = "Anno di pubblicazione")
    private LocalDate anno_pubblicazione;

    @Column(name = "Numero Pagine")
    private int numero_pagine;

    @Column(name = "Periodicità")
    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;


    public Rivista() {
    }

    public Rivista(String titolo, LocalDate anno_pubblicazione, int numero_pagine, Periodicità periodicità) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
        this.periodicità = periodicità;
    }

    public UUID getCodice_isbn() {
        return codice_isbn;
    }



    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(LocalDate anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "codice_isbn=" + codice_isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                ", periodicità=" + periodicità +
                '}';
    }
}
