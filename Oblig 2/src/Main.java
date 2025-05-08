import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        TVSerie houseMD = new TVSerie("House MD", "He is a doctod", LocalDate.of(2004, 11, 16));
        //Episode episode1 = new Episode("Pilot", 1, 1, 43);
        //Episode episode2 = new Episode("Paternity", 2, 1, 43);

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 11; j++) {
                Episode episoder = new Episode ("episode"+ " " + j, j, i, 43);
                houseMD.leggTilEpisoder(episoder);
            }
        }

        System.out.println(houseMD);
        System.out.println(houseMD.getEpisoderISesong(2));
    }
}
