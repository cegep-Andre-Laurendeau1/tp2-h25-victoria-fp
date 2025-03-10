package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateEmprunt;
    private boolean statut;

    @ManyToOne
    @JoinColumn
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
    private List<EmpruntDetail> empruntDetails;
}
