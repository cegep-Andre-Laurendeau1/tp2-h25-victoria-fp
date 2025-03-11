package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

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

    @Override
    public DVD getDVD(Long id) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Document> query = em.createQuery("SELECT dvd FROM Document dvd " +
                    "WHERE dvd.id = :id", Document.class);
            query.setParameter("id", id);
            return (DVD) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DVD findDVDByTitre(String titre) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Document> query = em.createQuery("SELECT dvd FROM DVD dvd " +
                    "WHERE lower(dvd.titre) LIKE ?1", Document.class);
            query.setParameter(1, "%" + titre.toLowerCase() + "%");
            return (DVD) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DVD findDVDByRealisateur(String realisateur) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<DVD> query = em.createQuery("SELECT dvd FROM DVD dvd " +
                    "WHERE lower(dvd.realisateur) LIKE ?1", DVD.class);
            query.setParameter(1, "%" + realisateur.toLowerCase() + "%");
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
