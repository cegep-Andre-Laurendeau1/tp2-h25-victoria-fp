package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
        return "Emprunteur(" +
                "id=" + getId() +
                ", nom=" + getNom() +
                ", prenom=" + getPrenom() +
                ", courriel=" + getCourriel() +
                ", telephone=" + getTelephone() +
                ", emprunts=" + getEmprunts() +
                ')';
    }
}
