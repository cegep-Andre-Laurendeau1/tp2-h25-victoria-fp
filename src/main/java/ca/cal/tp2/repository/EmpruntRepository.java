package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;

import java.util.List;

public interface EmpruntRepository {
    void saveEmprunt(Emprunt emprunt, EmpruntDetail empruntDetail, List<Document> documents);
}
