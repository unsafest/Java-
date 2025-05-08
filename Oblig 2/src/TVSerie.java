import java.time.LocalDate;
import java.util.ArrayList;

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
            oppdaterHjennomsnittligSpilletid();
            if (episode.getSesongNummer() > antallSesonger){
                antallSesonger += 1;
            }
        } else {
            System.out.println("\n" + "Sesongnummeret er ikke gyldig eller er større en logiske antall sesonger." + "\n");
        }
    }

    private void oppdaterHjennomsnittligSpilletid() {
        int totalSpilletid = 0;
        for (Episode episode : episodeListe) {
            totalSpilletid += episode.getSpilletid();
        }
        gjennomsnittligSpilletid = totalSpilletid / episodeListe.size();
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
        return "\n" + "Tittel: " + tittel + " - " + utgivelsesdato.getYear() + "\n" + 
        "Beskrivelse: " + beskrivelse + "\n" + 
        "Utgivelses dato: " + utgivelsesdato + "\n" +
        "Gjennomsnittlig spilletid: " + gjennomsnittligSpilletid + " min" + "\n" +
        "Antall sesonger: " + antallSesonger + "\n";
    }
}