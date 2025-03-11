package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmprunteurRepositoryJPA implements EmprunteurRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void saveEmprunteur(Emprunteur emprunteur) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(emprunteur);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Emprunteur getEmprunteur(Long id) {
        try {
            EntityManager em = emf.createEntityManager();

            TypedQuery<Emprunteur> query = em.createQuery("SELECT u FROM Emprunteur u " +
                    "LEFT JOIN FETCH u.emprunts WHERE u.id = :id", Emprunteur.class);
            query.setParameter("id", id);
            Emprunteur emprunteur = query.getSingleResult();

            return emprunteur;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Emprunt> getEmprunts(Long emprunteurId) {
        try {
            EntityManager em = emf.createEntityManager();

            TypedQuery<Emprunt> query = em.createQuery("SELECT u.emprunts FROM Emprunteur u " +
                    "WHERE u.id = :id", Emprunt.class);
            query.setParameter("id", emprunteurId);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
