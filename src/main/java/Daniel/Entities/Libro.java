package Daniel.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table ( name = "Libro")
public class Libro {

    @Id
    @GeneratedValue
    private UUID codice_isbn;

    @Column(name = "Titolo")
    private String titolo;

    @Column(name = "Anno di pubblicazione")
    private LocalDate anno_pubblicazione;

    @Column(name = "Numero Pagine")
    private int numero_pagine;

    @Column(name = "Autore")
    private String autore;

    @Column(name = "Genere")
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libro() {
    }

    public Libro(String titolo, LocalDate anno_pubblicazione, int numero_pagine, String autore, Genere genere) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
        this.autore = autore;
        this.genere = genere;
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
                "codice_isbn=" + codice_isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                ", autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
