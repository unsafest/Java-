import java.time.LocalDate;
import java.util.ArrayList;

public class TVSerie {
    private String tittel;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList<Episode> episodeListe;

    public TVSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato){
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        episodeListe = new ArrayList<>();
    }

    public void leggTilEpisoder(Episode episode) {
        episodeListe.add(episode);
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
        "Utgivelses dato: " + utgivelsesdato + "\n";
    }
}