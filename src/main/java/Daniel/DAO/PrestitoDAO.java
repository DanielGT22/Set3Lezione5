package Daniel.DAO;

import Daniel.Entities.Prestito;
import Daniel.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDAO {

    private final EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();

        System.out.println("Prestito effetuato " + prestito.getId_prestito());
    }

    public Prestito getById(long id) {
        return em.find(Prestito.class, id);
    }


    public void findByIdAndDelete(long id) {

        Prestito current = this.getById(id);

        if (current != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(current);
            transaction.commit();
            System.out.println("Prestito " + current.getId_prestito() + " è stato rimosso");
        } else {
            System.out.println("Prestito con il id: " + id + " non esiste");
        }


    }
}