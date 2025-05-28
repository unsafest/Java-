import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        TVSerie houseMD = new TVSerie("House MD", "He is a doctor", LocalDate.of(2004, 11, 16));
        TVSerie friends = new TVSerie("Friends", "A sitcom about six friends", LocalDate.of(1994, 9, 22));
        TVSerie theOffice = new TVSerie("The Office", "A mockumentary about office life", LocalDate.of(2005, 3, 24));   
        TVSerie seinfeld = new TVSerie("Seinfeld", "A show about nothing", LocalDate.of(1989, 7, 5));
        TVSerie breakingBad = new TVSerie("Breaking Bad", "A high school chemistry teacher turned methamphetamine manufacturer", LocalDate.of(2008, 1, 20));
        TVSerie gameOfThrones = new TVSerie("Game of Thrones", "A fantasy drama series based on the novels by George R.R. Martin", LocalDate.of(2011, 4, 17));  

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
        Collections.sort(houseMDEpisoder);
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
        " as " + conclave.getRolleListe().get(0).getRolleFornavn() + " " + conclave.getRolleListe().get(0).getRolleEtternavn() + "\n");

        ArrayList<TVSerie> tvserier = new ArrayList<>();
        tvserier.add(houseMD);
        tvserier.add(friends);
        tvserier.add(theOffice);
        tvserier.add(seinfeld);
        tvserier.add(breakingBad);
        tvserier.add(gameOfThrones);

        Collections.sort(tvserier);

        tvserier.forEach(serie -> System.out.println(serie.getTittel()));
    }
}
