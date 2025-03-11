package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LivreRepositoryJPA implements LivreRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void saveLivre(Livre livre) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(livre);
            em.getTransaction().commit();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Livre getLivre(Long id) {
        try {
            EntityManager em = emf.createEntityManager();
            TypedQuery<Document> query = em.createQuery("SELECT l FROM Document l " +
                    "WHERE l.id = :id", Document.class);
            query.setParameter("id", id);
            return (Livre) query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
