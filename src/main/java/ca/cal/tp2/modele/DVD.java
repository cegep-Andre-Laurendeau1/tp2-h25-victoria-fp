package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
@DiscriminatorValue("DVD")
public class DVD extends Document {
    private String realisateur;
    private int duree;
    private String note;
    private int delaiEmprunt = 7;

    public DVD(String titre, int nbExemplaires, String realisateur, int duree, String note) {
        super(titre, nbExemplaires);
        this.realisateur = realisateur;
        this.duree = duree;
        this.note = note;
    }

    public String toString() {
        return String.format(
                "CD(id=%d, titre=%s, nbExemplaires=%d, realisateur=%s, duree=%d, note=%s)",
                getId(), getTitre(), getNbExemplaires(), getRealisateur(), getDuree(), getNote()
        );
    }
}
