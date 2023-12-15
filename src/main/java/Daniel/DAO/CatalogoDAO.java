package Daniel.DAO;


import Daniel.Entities.Catalogo;
import Daniel.Entities.Libro;
import Daniel.Entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CatalogoDAO {
    private final EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public Catalogo findById(long id) {
        return em.find(Catalogo.class, id);
    }

    public Libro findCatById(long id) {
        return em.find(Libro.class, id);
    }

    public Rivista findDogById(long id) {
        return em.find(Rivista.class, id);
    }

    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("New entry saved");
    }

    public void findByIdAndDelete(long id) {
        Catalogo found = em.find(Catalogo.class, id);

        if (found != null) {

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Entry deleted");
        } else {
            System.err.println("Couldn't find entry with id (" + id + ") ");
        }
    }


    public List<Catalogo> findByName(String name) {

        TypedQuery<Catalogo> getAnimalsByName = em.createNamedQuery("findByName", Catalogo.class);
        getAnimalsByName.setParameter("name", name);
        return getAnimalsByName.getResultList();
    }

    public List<Catalogo> findByNameStartsWith(String partialName) {
        TypedQuery<Catalogo> getCatalogoByName = em.createNamedQuery("findByNameStartsWith", Catalogo.class);
        getCatalogoByName.setParameter("partialname", partialName);
        return getCatalogoByName.getResultList();
    }

    public List<Catalogo> findAllCatalogo() {
        TypedQuery<Catalogo> getAllQuery = em.createQuery("SELECT c FROM Catalogo c", Catalogo.class);
        return getAllQuery.getResultList();
    }

    public List<Libro> findAllLibri() {
        TypedQuery<Libro> getAllQuery = em.createQuery("SELECT l FROM Libro l", Libro.class);
        return getAllQuery.getResultList();
    }

    public List<Rivista> findAllRivista() {
        TypedQuery<Rivista> getAllQuery = em.createQuery("SELECT r FROM Rivista r", Rivista.class);
        return getAllQuery.getResultList();
    }

    public List<String> findAllAnimalsNames() {
        TypedQuery<String> getAllQuery = em.createQuery("SELECT a.name FROM Animal a", String.class);
        return getAllQuery.getResultList();
    }



}