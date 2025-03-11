package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.CDRepository;
import ca.cal.tp2.repository.EmprunteurRepository;
import ca.cal.tp2.repository.LivreRepository;

public class PreposeService {
    EmprunteurRepository emprunteurRepository;
    LivreRepository livreRepository;
    CDRepository cdRepository;

    public PreposeService(EmprunteurRepository emprunteurRepository,
                          LivreRepository livreRepository, CDRepository cdRepository) {
        this.emprunteurRepository = emprunteurRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
    }


    public void saveCD(String titre, int nbExemplaires, int annee, String artiste, int duree, String genre) {
        CD cd = new CD(titre, nbExemplaires, annee, artiste, duree, genre);
        cdRepository.saveCD(cd);
    }

    public CD getCD(Long id) {
        return cdRepository.getCD(id);
    }

    public CD findCDByTitre(String titre) {
        return cdRepository.findCDByTitre(titre);
    }

    public CD findCDByArtiste(String artiste) {
        return cdRepository.findCDByArtiste(artiste);
    }


    public void saveLivre(String titre, int nbExemplaires, int annee, String ISBN, String auteur, String editeur, int nbPages) {
        livreRepository.saveLivre(new Livre(titre, nbExemplaires, annee, ISBN, auteur, editeur, nbPages));
    }

    public Livre getLivre(Long id) {
        return livreRepository.getLivre(id);
    }

    public Livre findLivreByTitre(String titre) {
        return livreRepository.findLivreByTitre(titre);
    }

    public Livre findLivreByAuteur(String auteur) {
        return livreRepository.findLivreByAuteur(auteur);
    }


    public void saveEmprunteur(String nom, String prenom, String courriel, String telephone) {
        emprunteurRepository.saveEmprunteur(
                new Emprunteur(nom, prenom, courriel, telephone));
    }

    public Emprunteur getEmprunteur(Long id) {
        return emprunteurRepository.getEmprunteur(id);
    }
}
