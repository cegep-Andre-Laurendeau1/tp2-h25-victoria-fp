package ca.cal.tp2;

import ca.cal.tp2.repository.CDRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.repository.LivreRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();


        // Création des repositories et des services
        PreposeService preposeService = new PreposeService(
                new EmprunteurRepositoryJPA(), new LivreRepositoryJPA(), new CDRepositoryJPA()
        );
        EmprunteurService emprunteurService = new EmprunteurService(new EmpruntRepositoryJPA());


        // Création et recherche de documents
        preposeService.saveCD("Un titre", 200,
                "Un Artiste", 57, "metal");
        System.out.println(preposeService.getCD(1l));

        preposeService.saveCD("Lorem ipsum", 150,
                "Dolor Sit Amet", 73, "Conseqtur");
        System.out.println(preposeService.findCDByTitre("ipsum"));

        preposeService.saveCD("Troisieme disque compact", 375,
                "Jane Doe", 112, "genre");
        System.out.println(preposeService.findCDByArtiste("jane"));

        preposeService.saveLivre("Un livre", 90, "1234567890",
                "Auteur Quelconque", "Les éditions Editor", 98);
        System.out.println(preposeService.getLivre(52L));

        preposeService.saveLivre("L'Odyssée", 500, "87987294727",
                "Homère", "Les éditions Editor", 384);
        System.out.println(preposeService.findLivreByTitre("l'"));


        // Création d'un Emprunteur
        preposeService.saveEmprunteur("Doe", "John", "john.doe@gmail.com", "123-456-7890");
        System.out.println(preposeService.getEmprunteur(1L));


        // Emprunt de documents
        emprunteurService.emprunterDocuments(
                preposeService.getEmprunteur(1L),
                Arrays.asList(
                    preposeService.getCD(1L),
                    preposeService.getCD(2L)
                )
        );

        Thread.currentThread().join();
    }
}
