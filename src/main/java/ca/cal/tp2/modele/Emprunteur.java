package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("emprunteur")
public class Emprunteur extends Utilisateur {
    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    private List<Amende> amendes;

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    private List<Emprunt> emprunts;

    public Emprunteur(String nom, String prenom, String courriel, String telephone) {
        super(nom, prenom, courriel, telephone);
    }
}
