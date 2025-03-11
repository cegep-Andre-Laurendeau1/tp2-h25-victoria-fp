package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("livre")
public class Livre extends Document {
    private String ISBN;
    private String auteur;
    private String editeur;
    private int nbPages;
    private int delaiEmprunt = 21;

    public Livre(String titre, int nbExemplaires, String ISBN,
                 String auteur, String editeur, int nbPages) {
        super(titre, nbExemplaires);
        this.ISBN = ISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nbPages = nbPages;
    }

    public String toString() {
        return String.format(
                "Livre(id=%d, titre=%s, nbExemplaires=%d, ISBN=%s, auteur=%s, editeur=%s, nbPages=%d)",
                getId(), getTitre(), getNbExemplaires(), getISBN(), getAuteur(), getEditeur(), getNbPages()
        );
    }
}
