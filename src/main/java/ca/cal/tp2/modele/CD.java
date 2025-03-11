package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("CD")
public class CD extends Document {
    private String artiste;
    private int duree;
    private String genre;
    private int delaiEmprunt;

    public CD(String titre, int nbExemplaires, String artiste, int duree, String genre) {
        super(titre, nbExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
        this.delaiEmprunt = 14;
    }

    public String toString() {
        return String.format(
                "CD(id=%d, titre=%s, nbExemplaires=%d, artiste=%s, duree=%d, genre=%s, delai=%d)",
                getId(), getTitre(), getNbExemplaires(), getArtiste(), getDuree(), getGenre(), getDelaiEmprunt()
        );
    }
}
