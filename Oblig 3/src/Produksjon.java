import java.time.LocalDate;
import java.util.ArrayList;

public class Produksjon {
    private String tittel, beskrivelse;
    private int spilletid;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> rolleListe;

    public Produksjon(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.rolleListe = new ArrayList<>();
    }

    public void leggTilEnRolle(Rolle enRolle) {
        rolleListe.add(enRolle);
    }
    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller) {
        for (Rolle rolle : flereRoller) {
            rolleListe.add(rolle);
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
    public int getSpilletid() {
        return spilletid;
    }
    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }
    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }
    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }
    public Person getRegissor() {
        return regissor;
    }
    public Person setRegissor(Person regissor) {
        this.regissor = regissor;
        return regissor;
    }
    public ArrayList<Rolle> getRolleListe() {
        return rolleListe;
    }
    
    @Override
    public String toString() {
        return "Tittel: " + getTittel() + "\n" +
               "Beskrivelse: " + getBeskrivelse() + "\n" +
               "Utgivelsesdato: " + getUtgivelsesdato() + "\n";
    }
}
