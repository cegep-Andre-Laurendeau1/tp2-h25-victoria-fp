package ca.cal.tp2.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class CD extends Document {
    private final String artiste;
    private final int duree;
    private final String genre;

    public CD(long id, String titre, int nbExemplaires, String artiste, int duree, String genre) {
        super(id, titre, nbExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    public String toString() {
        return String.format(
                "CD(id=%d, titre=%s, nbExemplaires=%d, artiste=%s, duree=%d, genre=%s)",
                getId(), getTitre(), getNbExemplaires(), getArtiste(), getDuree(), getGenre()
        );
    }
}
