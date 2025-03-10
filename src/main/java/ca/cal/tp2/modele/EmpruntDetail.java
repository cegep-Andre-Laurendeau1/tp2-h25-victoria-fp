package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private boolean statut;

    @ManyToOne
    @JoinColumn
    private Emprunt emprunt;
}
