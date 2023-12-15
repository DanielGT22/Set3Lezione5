package Daniel.DAO;


import Daniel.Entities.Catalogo;
import Daniel.Entities.Libro;
import Daniel.Entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public Catalogo findById(long id) {
        return em.find(Catalogo.class, id);
    }

    public Libro findLibroById(long id) {
        return em.find(Libro.class, id);
    }

    public Rivista findRivistaById(long id) {
        return em.find(Rivista.class, id);
    }
    public Rivista findRivistaByTitolo(String titolo) {
        return em.find(Rivista.class, titolo);
    }
    public Libro findLibroByTitolo(String titolo) {
        return em.find(Libro.class, titolo);
    }
    public Libro findLibroByAnnoDiPubblicazione(LocalDate anno_di_pubblicazione) {
        return em.find(Libro.class, anno_di_pubblicazione);
    }
    public Rivista findRivistaByAnnoDiPubblicazione(LocalDate anno_di_pubblicazione) {
        return em.find(Rivista.class, anno_di_pubblicazione);
    }
    public Libro findLibroByAuttore(String auttore) {
        return em.find(Libro.class, auttore);
    }



    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("New entry saved");
    }





}