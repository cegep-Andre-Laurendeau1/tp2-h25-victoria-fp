package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle = null;
    private boolean statut = false;

    @ManyToOne
    @JoinColumn
    private Emprunt emprunt;

    @OneToMany
    List<Document> documents = new ArrayList<>();
}
