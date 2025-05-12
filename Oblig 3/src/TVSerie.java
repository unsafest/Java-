import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TVSerie {
    private String tittel;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episodeListe;
    private int gjennomsnittligSpilletid;
    private int antallSesonger;

    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato){
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        episodeListe = new ArrayList<>();
    }

    public void leggTilEpisoder(Episode episode) {
        if (episode.getSesongNummer() != 0 && episode.getSesongNummer() <= antallSesonger + 1 ){
            episodeListe.add(episode);
            oppdaterGjennomsnittligSpilletid();
            if (episode.getSesongNummer() > antallSesonger){
                antallSesonger += 1;
            }
        } else {
            System.out.println("\n" + "Sesongnummeret er ikke gyldig eller er større en logiske antall sesonger." + "\n");
        }
    }

    private void oppdaterGjennomsnittligSpilletid() {
        int totalSpilletid = 0;
        for (Episode episode : episodeListe) {
            totalSpilletid += episode.getSpilletid();
        }
        gjennomsnittligSpilletid = totalSpilletid / episodeListe.size();
    }

    public ArrayList<Rolle> hentRollebesetning() {
        ArrayList<Rolle> alleRoller = new ArrayList<>();
        for (Episode episode : episodeListe) {
            alleRoller.addAll(episode.getRolleListe());
        }
        return new ArrayList<>(alleRoller.stream().distinct().collect(Collectors.toList()));
    }
    public void hentAlleRoller() {
        HashMap<Person, Integer> rolleMap = new HashMap<>();
        for (Episode episode : episodeListe) {
            for (Rolle rolle : episode.getRolleListe()) {
                Person skuespiller = rolle.getSkuespiller();
                rolleMap.merge(skuespiller, 1, Integer::sum);
            }
        }
        System.out.println("\nSkuepillere og antall episoder: ");
        for (Map.Entry<Person,Integer> entry : rolleMap.entrySet()) {
            System.out.println(entry.getKey().getFullNavn() + " - " + entry.getValue() + " episoder");
        }
    }
    
    public String getTittel() {
        return tittel;
    }
    public void setTittel(String tittel) {
        this.tittel = tittel;
    }
    public String getBeskrivelse() {
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }
    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }
    public ArrayList<Episode> getEpisodeListe() {
        return new ArrayList<>(episodeListe);
    }
    public int getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }
    public int getAntallSesonger() {
        return antallSesonger;
    }

    public String getEpisodeListeString() {
        StringBuilder sb = new StringBuilder();
        for (Episode episode : episodeListe) {
            sb.append(episode).append("\n");
        }
        return sb.toString();
    }

    public ArrayList<Episode> getEpisoderISesong(int sesong) {
        ArrayList<Episode> episoderISesong = new ArrayList<>();
        for (Episode episode : episodeListe) {
            if (episode.getSesongNummer() == sesong) {
                episoderISesong.add(episode);
            }
        }
        return episoderISesong;
    }

    @Override
    public String toString() {
        return "\n" + "Tittel: " + getTittel() + " - " + getUtgivelsesdato().getYear() + "\n" + 
        "Beskrivelse: " + getBeskrivelse() + "\n" + 
        "Utgivelses dato: " + getUtgivelsesdato() + "\n" +
        "Gjennomsnittlig spilletid: " + getGjennomsnittligSpilletid() + " min" + "\n" +
        "Antall sesonger: " + getAntallSesonger() + "\n";
    }
}