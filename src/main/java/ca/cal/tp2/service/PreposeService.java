package ca.cal.tp1.service;

import ca.cal.tp1.modele.CD;
import ca.cal.tp1.repository.CDRepository;

public class PreposeService {
    CDRepository cdRepository;

    public PreposeService(CDRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    public void saveCD(long id, String titre, int nbExemplaires, String artiste, int duree, String genre) {
        CD cd = new CD(id, titre, nbExemplaires, artiste, duree, genre);
        cdRepository.saveCD(cd);
    }

    public CD getCD(long id) {
        return cdRepository.getCD(id);
    }
}
