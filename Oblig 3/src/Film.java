import java.time.LocalDate;

public class Film extends Produksjon {

    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
    }
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato);
        setRegissor(regissor);
    }

}
