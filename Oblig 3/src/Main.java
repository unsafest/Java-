import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        TVSerie houseMD = new TVSerie("House MD", "He is a doctor", LocalDate.of(2004, 11, 16));
        
        Person person = new Person("Edward", "Norton", LocalDate.of(1970, 3, 6));
        Film conclave = new Film("Conclave", 
        "A movie about the papal conclave", 
        120, 
        LocalDate.of(2023, 10, 20),
        person);

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                Random random = new Random();
                Episode episoder = new Episode ("episode " +  j, "Is it lupus?", j, i, (random.nextInt(50 - 40) + 40), null, person);
                houseMD.leggTilEpisoder(episoder);
            }
        }
        //ArrayList<Episode> houseMDEpisoder = houseMD.getEpisodeListe();
        ArrayList<Episode> houseMDEpisoder = houseMD.getEpisoderISesong(2);
        
        System.out.println(houseMD);
        
        Person greg = new Person("Hugh", "Laurie", LocalDate.of(1959, 6, 11));
        Person wilson = new Person("Robert", "Leonard", LocalDate.of(1969, 6, 28));

        Rolle drHouse = new Rolle("Gregory", "House", greg);
        Rolle drWilson = new Rolle("James", "Wilson", wilson);

        for (Episode episode : houseMDEpisoder) {
            episode.leggTilEnRolle(drHouse);
            if (episode.getEpisodeNummer() % 2 == 0) {
                episode.leggTilEnRolle(drWilson);
            }

            System.out.println(episode); // + " " + episode.getRegissor().getFullNavn()
        }
        
        for (Rolle rolle : houseMD.hentRollebesetning()) {
            System.out.println(rolle);
        }
        houseMD.hentAlleRoller();
        
        Episode episode42 = new Episode("It's lupus", "This time it's actually lupus", 1, 7, 50, null);
        houseMD.leggTilEpisoder(episode42);
        
        System.out.println("Antall sesnonger: " + houseMD.getAntallSesonger() + "\n");
        
        conclave.setRegissor(person);
        
        conclave.leggTilEnRolle(drHouse);

        System.out.println(conclave.getTittel() + "\n" + 
        "Directed by: " + conclave.getRegissor().getFullNavn() + "\n" +
        "Starring: " + conclave.getRolleListe().get(0).getSkuespiller().getFullNavn() + 
        " as " + conclave.getRolleListe().get(0).getRolleFornavn() + " " + conclave.getRolleListe().get(0).getRolleEtternavn());

    }
}
