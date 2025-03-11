package ca.cal.tp2;

import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();


        // Création des repositories et des services
        PreposeService preposeService = new PreposeService(
                new EmprunteurRepositoryJPA(), new EmpruntRepositoryJPA(), new LivreRepositoryJPA(),
                new CDRepositoryJPA(), new DVDRepositoryJPA()
        );
        EmprunteurService emprunteurService = new EmprunteurService(new EmpruntRepositoryJPA());


        // Création de documents
        preposeService.saveCD(
                "Un titre",
                200,
                1992,
                "Un Artiste",
                57,
                "metal");

        preposeService.saveCD(
                "Lorem ipsum",
                150,
                2001,
                "Dolor Sit Amet",
                73,
                "Conseqtur");

        preposeService.saveCD(
                "Troisieme disque compact",
                375,
                2005,
                "Jane Doe",
                112,
                "genre");

        preposeService.saveLivre(
                "Un livre",
                90,
                1903,
                "1234567890",
                "Auteur Quelconque",
                "Les éditions Editor",
                98);

        preposeService.saveLivre(
                "L'Odyssée",
                500,
                -709,
                "7987294727",
                "Homère",
                "Les éditions Editor",
                384);

        preposeService.saveLivre(
                "Troisieme roman",
                380,
                2023,
                "9999999999",
                "Nom Original",
                "Alire",
                928);

        preposeService.saveDVD(
                "Le titanic",
                120,
                1999,
                "James Cameron",
                195,
                "4.7 etoiles");

        preposeService.saveDVD(
                "Un documentaire",
                120, 2000,
                "National Geographic",
                195,
                "3.9 etoiles");

        preposeService.saveDVD(
                "Troisieme DVD",
                380,
                2012,
                "Real Isateur",
                156,
                "2.1 etoiles");


        // Recherche de documents
        System.out.println("getCD() : " + preposeService.getCD(1l));
        System.out.println("Recherche par titre : " + preposeService.findCDByTitre("ipsum"));
        System.out.println("Recherche par artiste : " + preposeService.findCDByArtiste("jane") + "\n");

        System.out.println("getLivre() : " + preposeService.getLivre(52L));
        System.out.println("Recherche par titre : " + preposeService.findLivreByTitre("l'"));
        System.out.println("Recherche par auteur : " + preposeService.findLivreByAuteur("Auteur"));
        System.out.println("Recherche par annee : " + preposeService.findLivreByAnnee(2023) + "\n");

        System.out.println("getDVD() : " + preposeService.getDVD(102L));
        System.out.println("Recherche par titre : " + preposeService.findDVDByTitre("troisieme"));
        System.out.println("Recherche par realisateur : " +
                preposeService.findDVDByRealisateur("National Geographic") + "\n");


        // Création d'un Emprunteur
        preposeService.saveEmprunteur(
                "Doe",
                "John",
                "john.doe@gmail.com",
                "123-456-7890");
        System.out.println("Avant emprunt : " + preposeService.getEmprunteur(1L));


        // Emprunt de documents
        emprunteurService.emprunterDocuments(
                preposeService.getEmprunteur(1L),
                Arrays.asList(
                    preposeService.getCD(1L),
                    preposeService.getCD(2L)
                )
        );
        System.out.println("Après emprunt : " + preposeService.getEmprunteur(1L));

        Thread.currentThread().join();
    }
}
