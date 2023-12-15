package Daniel.DAO;

import Daniel.Entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {

    private final EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();

        System.out.println("Utente aggiunto " + utente.getNome());
    }

    public Utente getById(long id) {
        return em.find(Utente.class, id);
    }


    public void findByIdAndDelete(long id) {

        Utente current = this.getById(id);

        if (current != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(current);
            transaction.commit();
            System.out.println("Utente " + current.getNome() + " è stato rimosso");
        } else {
            System.out.println("Utente con il id: " + id + " non esiste");
        }


    }
}