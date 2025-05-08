import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        TVSerie houseMD = new TVSerie("House MD", 
        "He is a doctod", 
        LocalDate.of(2004, 11, 16));
        //Episode episode1 = new Episode("Pilot", 1, 1, 43);
        //Episode episode2 = new Episode("Paternity", 2, 1, 43);

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 11; j++) {
                Random random = new Random();
                Episode episoder = new Episode ("episode"+ " " + j, j, i, (random.nextInt(50 - 40) + 40));
                houseMD.leggTilEpisoder(episoder);
            }
        }
        //ArrayList<Episode> houseMDEpisoder = houseMD.getEpisodeListe();
        ArrayList<Episode> houseMDEpisoder = houseMD.getEpisoderISesong(2);
        
        System.out.println(houseMD);

        for (Episode episode : houseMDEpisoder) {
            System.out.println(episode);
        }
        Episode episode69 = new Episode("It's lupus", 1, 6, 50);
        houseMD.leggTilEpisoder(episode69);
        System.out.println("Antall sesnonger: " + houseMD.getAntallSesonger() + "\n");
    }
}
