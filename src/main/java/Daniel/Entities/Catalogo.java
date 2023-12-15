package Daniel.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Prodotti")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_prodotto")

@NamedQuery(name = "findByName", query = "SELECT a FROM Libro a WHERE a.name = :name")
@NamedQuery(name = "findByNameStartsWith", query = "SELECT a FROM Libro a WHERE LOWER(a.name) LIKE LOWER(CONCAT(:partialname, '%'))")
public abstract class Catalogo {
    @Id
    @GeneratedValue
    private UUID codice_isbn;

    @Column(name = "Titolo")
    public String titolo;

    @Column(name = "Anno di pubblicazione")
    public LocalDate anno_pubblicazione;

    @Column(name = "Numero Pagine")
    public int numero_pagine;

    public Catalogo(String titolo, LocalDate anno_pubblicazione, int numero_pagine) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public Catalogo() {
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

    @Override
    public String toString() {
        return "Catalogo{" +
                "codice_isbn=" + codice_isbn +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}