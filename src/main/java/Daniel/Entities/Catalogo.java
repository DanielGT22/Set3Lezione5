package Daniel.Entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Prodotti")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_prodotto")
@NamedQuery(name = "findByYear", query = "SELECT c FROM Catalogo c WHERE c.anno_di_pubblicazione = :anno_di_pubblicazione")
@NamedQuery(name = "findByISBN", query = "SELECT c FROM Catalogo c WHERE c.codice_isbn = :isbn")
@NamedQuery(name = "findByName", query = "SELECT c FROM Catalogo c WHERE c.titolo = :titolo")
@NamedQuery(name = "findByNameStartsWith", query = "SELECT c FROM Catalogo c WHERE LOWER(c.titolo) LIKE LOWER(CONCAT(:partialname, '%'))")

public abstract class Catalogo {
    @Id
    @GeneratedValue
    private UUID codice_isbn;

    @Column(name = "Titolo")
    public String titolo;

    @Column(name = "Anno_di_pubblicazione")
    public LocalDate anno_di_pubblicazione;

    @Column(name = "Numero_pagine")
    public int numero_pagine;

    public Catalogo(String titolo, LocalDate anno_pubblicazione, int numero_pagine) {
        this.titolo = titolo;
        this.anno_di_pubblicazione = anno_pubblicazione;
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
        return anno_di_pubblicazione;
    }

    public void setAnno_pubblicazione(LocalDate anno_pubblicazione) {
        this.anno_di_pubblicazione = anno_pubblicazione;
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
                ", anno_pubblicazione=" + anno_di_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}