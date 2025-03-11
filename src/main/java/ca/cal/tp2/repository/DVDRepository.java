package ca.cal.tp2.repository;

import ca.cal.tp2.modele.DVD;

public interface DVDRepository {
    void saveDVD(DVD dvd);
    DVD getDVD(Long id);
    DVD findDVDByTitre(String titre);
    DVD findDVDByRealisateur(String realisateur);
}
