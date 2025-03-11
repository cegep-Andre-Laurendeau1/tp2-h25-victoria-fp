package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("emprunteur")
public class Emprunteur extends Utilisateur {
    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    private List<Amende> amendes = new ArrayList<>();

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.ALL)
    private List<Emprunt> emprunts = new ArrayList<>();

    public Emprunteur(String nom, String prenom, String courriel, String telephone) {
        super(nom, prenom, courriel, telephone);
    }

    @Override
    public String toString() {
        return String.format(
                "Emprunteur(id=%d, nom=%s, prenom=%s, email=%s, tel=%s)",
                getId(), getNom(), getPrenom(), getCourriel(), getTelephone()
        );
    }
}
