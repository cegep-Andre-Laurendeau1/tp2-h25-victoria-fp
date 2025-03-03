package ca.cal.tp1.repository;

import ca.cal.tp1.modele.CD;

public interface CDRepository {
    public void saveCD(CD cd);
    public CD getCD(long id);
}
