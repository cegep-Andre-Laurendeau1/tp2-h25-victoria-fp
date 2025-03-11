package ca.cal.tp2.repository;

import ca.cal.tp2.modele.DVD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DVDRepositoryJPA implements DVDRepository {
    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("tp2");

    @Override
    public void saveDVD(DVD dvd) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
