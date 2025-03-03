package ca.cal.tp1.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DVD extends Document {
    private final String realisateur;
    private final int duree;
    private final String note;

    public DVD(long id, String titre, int nbExemplaires, String realisateur, int duree, String note) {
        super(id, titre, nbExemplaires);
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
