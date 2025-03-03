package ca.cal.tp1.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Utilisateur {
    private long id;
    private String nom;
    private String prenom;
    private String courriel;
    private String telephone;
}
