package ca.cal.tp1.modele;

import lombok.Data;

import java.util.Date;

@Data
public class Amende {
    private final long id;
    private final double montant;
    private final Date dateCreation;
    private final boolean statut;
    private final Emprunteur emprunteur;
}
