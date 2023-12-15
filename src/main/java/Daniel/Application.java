package Daniel;

import Daniel.DAO.CatalogoDAO;
import Daniel.Entities.Genere;
import Daniel.Entities.Libro;
import Daniel.Entities.Periodicità;
import Daniel.Entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Gestione");
    public static void main(String[] args) {
        System.out.println("Hello World!");

        EntityManager em = emf.createEntityManager();

        CatalogoDAO cd = new CatalogoDAO(em);

        Libro percy_jackson = new Libro("Percy Jackson", LocalDate.of(2005,04,05), 204, "Robert Venditti", Genere.FANTASY);
        Libro harry_potter = new Libro("Harry Potter and the Philosopher's Stone", LocalDate.of(1997, 6, 26), 320, "J.K. Rowling", Genere.FANTASY);
        Libro il_signore_degli_anelli = new Libro("The Lord of the Rings", LocalDate.of(1954, 7, 29), 1178, "J.R.R. Tolkien", Genere.FANTASY);
        Libro codice_da_vinci = new Libro("The Da Vinci Code", LocalDate.of(2003, 3, 18), 454, "Dan Brown", Genere.MYSTERY);
        Libro il_grande_gatsby = new Libro("The Great Gatsby", LocalDate.of(1925, 4, 10), 180, "F. Scott Fitzgerald", Genere.ROMANCE);
        Rivista national_geographic = new Rivista("National Geographic", LocalDate.of(1888, 10, 1), 150, Periodicità.MENSILE);
        Rivista time_magazine = new Rivista("Time Magazine", LocalDate.of(1923, 3, 3), 64, Periodicità.SETTIMANALE);
        Rivista scientific_american = new Rivista("Scientific American", LocalDate.of(1845, 8, 28), 82, Periodicità.MENSILE);
        Rivista sports_illustrated = new Rivista("Sports Illustrated", LocalDate.of(1954, 8, 16), 56, Periodicità.SETTIMANALE);
        Rivista fashion_vogue = new Rivista("Vogue", LocalDate.of(1892, 12, 17), 300, Periodicità.SEMESTRALE);

        cd.save(percy_jackson);
		cd.save(harry_potter);
        cd.save(il_signore_degli_anelli);
        cd.save(harry_potter);
        cd.save(codice_da_vinci);
        cd.save(il_grande_gatsby);

        cd.save(national_geographic);
        cd.save(time_magazine);
        cd.save(scientific_american);
        cd.save(sports_illustrated);
        cd.save(fashion_vogue);


    }
}
