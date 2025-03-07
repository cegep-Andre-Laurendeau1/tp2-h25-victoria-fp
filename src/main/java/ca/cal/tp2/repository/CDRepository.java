package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;

public interface CDRepository {
    public void saveCD(CD cd);
    public CD getCD(Long id);
    public CD findCDByTitre(String titre);
}
