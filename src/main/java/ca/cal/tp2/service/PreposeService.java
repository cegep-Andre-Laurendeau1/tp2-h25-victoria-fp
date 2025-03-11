package ca.cal.tp2.service;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.CDRepository;
import ca.cal.tp2.repository.DVDRepository;
import ca.cal.tp2.repository.EmprunteurRepository;
import ca.cal.tp2.repository.LivreRepository;

import java.util.List;

public class PreposeService {
    EmprunteurRepository emprunteurRepository;
    LivreRepository livreRepository;
    CDRepository cdRepository;
    DVDRepository dvdRepository;

    public PreposeService(EmprunteurRepository emprunteurRepository,
                          LivreRepository livreRepository, CDRepository cdRepository,
                          DVDRepository dvdRepository) {
        this.emprunteurRepository = emprunteurRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
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


    public void saveLivre(String titre, int nbExemplaires, int annee, String ISBN,
                          String auteur, String editeur, int nbPages) {
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

    public Livre findLivreByAnnee(int annee) {
        return livreRepository.findLivreByAnnee(annee);
    }


    public void saveEmprunteur(String nom, String prenom, String courriel, String telephone) {
        emprunteurRepository.saveEmprunteur(
                new Emprunteur(nom, prenom, courriel, telephone));
    }

    public Emprunteur getEmprunteur(Long id) {
        return emprunteurRepository.getEmprunteur(id);
    }

    public List<Emprunt> getEmprunts(Long emprunteurId) {
        return emprunteurRepository.getEmprunts(emprunteurId);
    }


    public void saveDVD(String titre, int nbExemplaires, int annee, String realisateur, int duree, String note) {
        dvdRepository.saveDVD(new DVD(titre, nbExemplaires, annee, realisateur, duree, note));
    }

    public DVD getDVD(Long id) {
        return dvdRepository.getDVD(id);
    }

    public DVD findDVDByTitre(String titre) {
        return dvdRepository.findDVDByTitre(titre);
    }

    public DVD findDVDByRealisateur(String realisateur) {
        return dvdRepository.findDVDByRealisateur(realisateur);
    }
}
