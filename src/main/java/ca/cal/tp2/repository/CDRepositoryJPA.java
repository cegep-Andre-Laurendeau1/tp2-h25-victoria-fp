package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Document;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class CDRepositoryJPA implements CDRepository {

    private final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("tp2");

    @Override
    public void saveCD(CD cd) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(cd);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CD getCD(Long id) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Document> query = em.createQuery("SELECT cd FROM Document cd " +
                    "WHERE cd.id = :id", Document.class);
            query.setParameter("id", id);
            return (CD) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CD findCDByTitre(String titre) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Document> query = em.createQuery("SELECT cd FROM CD cd " +
                    "WHERE lower(cd.titre) LIKE ?1", Document.class);
            query.setParameter(1, "%" + titre.toLowerCase() + "%");
            return (CD) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CD findCDByArtiste(String artiste) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<CD> query = em.createQuery("SELECT cd FROM CD cd " +
                    "WHERE lower(cd.artiste) LIKE ?1", CD.class);
            query.setParameter(1, "%" + artiste.toLowerCase() + "%");
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
