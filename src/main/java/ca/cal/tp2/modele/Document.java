package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_document")
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private int nbExemplaires;
    private int delaiEmprunt;

    @ManyToOne
    @JoinColumn
    EmpruntDetail empruntDetail;

    public Document(String titre, int nbExemplaires) {
        this.titre = titre;
        this.nbExemplaires = nbExemplaires;
    }
}
