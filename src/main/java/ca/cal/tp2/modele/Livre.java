package ca.cal.tp2.modele;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Livre extends Document {
    private final String ISBN;
    private final String auteur;
    private final String editeur;
    private final int nbPages;

    public Livre(long id, String titre, int nbExemplaires, String ISBN,
                 String auteur, String editeur, int nbPages) {
        super(id, titre, nbExemplaires);
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
