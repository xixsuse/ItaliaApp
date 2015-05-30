package model;

/**
 *
 * @author Admin
 */
public class Provincia {

    private int codRegione;
    private int codProvincia;
    private String sigla;
    private String descrizione;

    public Provincia(int codRegione, int codProvincia, String sigla, String descrizione) {
        this.codRegione = codRegione;
        this.codProvincia = codProvincia;
        this.sigla = sigla;
        this.descrizione = descrizione;
    }

    public int getCodRegione() {
        return codRegione;
    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return "codRegione=" + codRegione + ", codProvincia=" + codProvincia + ", sigla=" + sigla + ", descrizione=" + descrizione + '}';
    }

}
