package ca.cal.tp2.modele;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Emprunt {
    private final long id;
    private final Date dateEmprunt;
    private final boolean statut;
    private final Emprunteur emprunteur;
    private final List<EmpruntDetail> empruntDetails;
}
