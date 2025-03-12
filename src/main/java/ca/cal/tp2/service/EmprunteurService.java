package ca.cal.tp2.service;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.EmpruntRepository;

import java.time.LocalDate;
import java.util.List;


public class EmprunteurService {
    private final EmpruntRepository empruntRepository;

    public EmprunteurService(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    public void emprunterDocuments(Emprunteur emprunteur, List<Document> documents) {

        // Vérification de la disponibilité des documents
        documents.forEach(document -> {
            if (!isDocumentDisponible(document)) {
                throw new RuntimeException("Le document " + document.getTitre() + " est indisponible.");
            }
        });


        // Création d'un EmpruntDetail
        EmpruntDetail empruntDetail = new EmpruntDetail();

        LocalDate dateEmprunt = LocalDate.now();
        LocalDate dateRetourPrevue = dateEmprunt.plusDays(documents.get(0).getDelaiEmprunt());
        empruntDetail.setDateRetourPrevue(dateRetourPrevue);


        // Création de l'emprunt
        Emprunt emprunt = new Emprunt();
        emprunt.setDateEmprunt(dateEmprunt);
        emprunt.addEmpruntDetail(empruntDetail);
        emprunt.setEmprunteur(emprunteur);

        empruntRepository.saveEmprunt(emprunt, empruntDetail, documents);
    }

    private boolean isDocumentDisponible(Document document) {
        return document.getNbExemplaires() - empruntRepository.getNbEmpruntDetails(document) > 0;
    }
}
