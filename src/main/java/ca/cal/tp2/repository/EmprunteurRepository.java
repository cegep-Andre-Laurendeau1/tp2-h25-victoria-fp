package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;

import java.util.List;

public interface EmprunteurRepository {
    void saveEmprunteur(Emprunteur emprunteur);
    Emprunteur getEmprunteur(Long id);
    List<Emprunt> getEmprunts(Long emprunteurId);
}
