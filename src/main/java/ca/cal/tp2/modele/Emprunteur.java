package ca.cal.tp2.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Emprunteur extends Utilisateur {
    private final List<Amende> amendes;
    private final List<Emprunt> emprunts;
}
