import java.time.LocalDate;

public class Episode extends Produksjon {
    private int episodeNummer;
    private int sesongNummer;

    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }
    public Episode(String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        setRegissor(regissor);
    }
    public Episode(String tittel, int episodeNummer, int sesongNummer) {
        super(tittel, "", 0, null);
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }
    public void setEpisodeNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }
    public int getSesongNummer() {
        return sesongNummer;
    }
    public void setSesong(int sesongNummer) {
        this.sesongNummer = sesongNummer;
    }

    @Override
    public String toString(){
        return "E" + episodeNummer + "S" + sesongNummer + 
        ": " + getTittel() + " (" + getSpilletid() + " min)";
    }
}
