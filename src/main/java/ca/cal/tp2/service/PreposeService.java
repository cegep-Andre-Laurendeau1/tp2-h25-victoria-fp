package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.repository.CDRepository;

public class PreposeService {
    CDRepository cdRepository;

    public PreposeService(CDRepository cdRepository) {
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
}
