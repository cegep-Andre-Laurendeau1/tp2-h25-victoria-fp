package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;

public interface LivreRepository {
    void saveLivre(Livre livre);
    Livre getLivre(Long id);
    Livre findLivreByTitre(String titre);
    Livre findLivreByAuteur(String auteur);
    Livre findLivreByAnnee(int annee);
}
