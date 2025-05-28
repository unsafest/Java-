import java.time.LocalDate;

public class Film extends Produksjon implements Comparable<Film> {

    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
    }
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
        setRegissor(regissor);
    }

    @Override
    public int compareTo(Film o) {
        return this.getTittel().compareTo(o.getTittel());
    }

}
