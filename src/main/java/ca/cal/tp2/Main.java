package ca.cal.tp2;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.CDRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();


        // Création des repositories et des services
        PreposeService preposeService = new PreposeService(new EmprunteurRepositoryJPA(), new CDRepositoryJPA());
        EmprunteurService emprunteurService = new EmprunteurService(new EmpruntRepositoryJPA());


        // Création de CDs
        preposeService.saveCD("Un titre", 200,
                "Un Artiste", 57, "metal");
        System.out.println(preposeService.getCD(1l));

        preposeService.saveCD("Lorem ipsum", 150,
                "Dolor Sit Amet", 73, "Conseqtur");
        System.out.println(preposeService.findCDByTitre("ipsum"));

        preposeService.saveCD("Troisieme disque compact", 375,
                "Jane Doe", 112, "genre");
        System.out.println(preposeService.findCDByArtiste("jane"));


        // Création d'un Emprunteur
        preposeService.saveEmprunteur("Doe", "John", "john.doe@gmail.com", "123-456-7890");
        Emprunteur emprunteur1 = preposeService.getEmprunteur(1L);
        System.out.println(emprunteur1);


        // Emprunt de documents
        emprunteurService.emprunterDocuments(
                emprunteur1,
                Arrays.asList(
                    preposeService.getCD(1L),
                    preposeService.getCD(2L)
                )
        );

        Thread.currentThread().join();
    }
}
