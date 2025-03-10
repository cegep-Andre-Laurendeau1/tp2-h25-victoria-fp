package ca.cal.tp2;

import ca.cal.tp2.repository.CDRepositoryJPA;
import ca.cal.tp2.repository.EmprunteurRepositoryJPA;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();
        PreposeService preposeService = new PreposeService(new EmprunteurRepositoryJPA(), new CDRepositoryJPA());


        preposeService.saveCD("Un titre", 200,
                "Un Artiste", 57, "metal");
        System.out.println(preposeService.getCD(1l));

        preposeService.saveCD("Lorem ipsum", 150,
                "Dolor Sit Amet", 73, "Conseqtur");
        System.out.println(preposeService.findCDByTitre("ipsum"));

        preposeService.saveCD("Troisieme disque compact", 375,
                "Jane Doe", 112, "genre");
        System.out.println(preposeService.findCDByArtiste("jane"));


        preposeService.saveEmprunteur("Doe", "John", "john.doe@gmail.com", "123-456-7890");

        Thread.currentThread().join();
    }
}
