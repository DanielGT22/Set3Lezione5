package Daniel.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table ( name = "Libro")
public class Libro  extends Catalogo{


    @Column(name = "Autore")
    private String autore;

    @Column(name = "Genere")
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libro() {
    }

    public Libro(String titolo, LocalDate anno_di_pubblicazione, int numero_pagine, String autore, Genere genere) {
       this.titolo = titolo;
       this.anno_di_pubblicazione = anno_di_pubblicazione;
       this.numero_pagine = numero_pagine;
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }



    @Override
    public String toString() {
        return "Libro{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                ", titolo='" + titolo + '\'' +
                ", anno_di_pubblicazione=" + anno_di_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }

}
