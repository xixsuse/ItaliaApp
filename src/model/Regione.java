package model;

/**
 *
 * @author Admin
 */
public class Regione {

    private int codiceRegione;
    private String descrizione;

    public Regione(int codiceRegione, String descrizione) {
        this.codiceRegione = codiceRegione;
        this.descrizione = descrizione;
    }

    public int getCodiceRegione() {
        return codiceRegione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return "codiceRegione=" + codiceRegione + ", descrizione=" + descrizione + '}';
    }

}
