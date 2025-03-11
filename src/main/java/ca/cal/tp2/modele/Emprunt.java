package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateEmprunt;
    private boolean statut = false;

    @ManyToOne
    @JoinColumn
    private Emprunteur emprunteur;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL)
    private List<EmpruntDetail> empruntDetails = new ArrayList<>();

    public void addEmpruntDetail(EmpruntDetail empruntDetail) {
        empruntDetails.add(empruntDetail);
        setEmpruntDetails(empruntDetails);
    }
}
