package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmpruntRepositoryJPA implements EmpruntRepository {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void saveEmprunt(Emprunt emprunt, EmpruntDetail empruntDetail, List<Document> documents) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            em.persist(emprunt);
            empruntDetail.setEmprunt(emprunt);

            empruntDetail.setDocuments(documents);
            em.getTransaction().commit();
        }
        catch (Exception e) {
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
