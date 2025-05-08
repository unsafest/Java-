public class Episode {
    private String tittel;
    private int episodeNummer;
    private int sesongNummer;
    private int spilletid;

    public Episode(String tittel, int episodeNummer, int sesongNummer, int spilletid) {
        this.tittel = tittel;
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
        this.spilletid = spilletid;
    }
    public Episode(String tittel, int episodeNummer, int sesongNummer) {
        this.tittel = tittel;
        this.episodeNummer = episodeNummer;
        this.sesongNummer = sesongNummer;
    }

    public String getTittel() {
        return tittel;
    }
    public void setTittel(String tittel) {
        this.tittel = tittel;
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
    public int getSpilletid() {
        return spilletid;
    }
    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }
    @Override
    public String toString(){
        return "E" + episodeNummer + "S" + sesongNummer + 
        ": " + tittel + " (" + spilletid + " min)";
    }
}
