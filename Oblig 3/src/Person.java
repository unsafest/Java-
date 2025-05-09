import java.time.LocalDate;

public class Person {
    private String fornavn, etternavn;
    private LocalDate fDato;
    
    public Person(String fornavn, String etternavn, LocalDate fDato) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fDato = fDato;
    }

    public String getFullNavn() {
        return fornavn + " " + etternavn;
    }
    
    public String getFornavn() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }
    public String getEtternavn() {
        return etternavn;
    }
    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }
    public LocalDate getfDato() {
        return fDato;
    }
    public void setfDato(LocalDate fDato) {
        this.fDato = fDato;
    }
}
