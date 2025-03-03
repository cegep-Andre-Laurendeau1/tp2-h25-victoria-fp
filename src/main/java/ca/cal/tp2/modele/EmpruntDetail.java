package ca.cal.tp1.modele;

import lombok.Data;

import java.util.Date;

@Data
public class EmpruntDetail {
    private final long id;
    private final Date dateRetourPrevue;
    private final Date dateRetourActuelle;
    private final boolean statut;
    private final Emprunt emprunt;
}
