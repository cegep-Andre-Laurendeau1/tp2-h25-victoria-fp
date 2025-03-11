package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.CDRepository;
import ca.cal.tp2.repository.EmprunteurRepository;

public class PreposeService {
    EmprunteurRepository emprunteurRepository;
    CDRepository cdRepository;

    public PreposeService(EmprunteurRepository emprunteurRepository, CDRepository cdRepository) {
        this.emprunteurRepository = emprunteurRepository;
        this.cdRepository = cdRepository;
    }

    public void saveCD(String titre, int nbExemplaires, String artiste, int duree, String genre) {
        CD cd = new CD(titre, nbExemplaires, artiste, duree, genre);
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

    public void saveEmprunteur(String nom, String prenom, String courriel, String telephone) {
        emprunteurRepository.saveEmprunteur(
                new Emprunteur(nom, prenom, courriel, telephone));
    }

    public Emprunteur getEmprunteur(Long id) {
        return emprunteurRepository.getEmprunteur(id);
    }
}
