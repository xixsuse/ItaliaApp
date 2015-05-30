package model;

/**
 *
 * @author Admin
 */
public class Comune {

    private int codRegione;
    private int codProvincia;
    private String istat;
    private String descrizione;
    private float superficie;
    private int numPopolazione;

    public Comune(int codRegione, int codProvincia, String istat, String descrizione, float superficie, int numPopolazione) {
        this.codRegione = codRegione;
        this.codProvincia = codProvincia;
        this.istat = istat;
        this.descrizione = descrizione;
        this.superficie = superficie;
        this.numPopolazione = numPopolazione;
    }

    public int getCodRegione() {
        return codRegione;
    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public String getIstat() {
        return istat;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public float getSuperficie() {
        return superficie;
    }

    public int getNumPopolazione() {
        return numPopolazione;
    }

    @Override
    public String toString() {
        return "codRegione=" + codRegione + ", codProvincia=" + codProvincia + ", istat=" + istat + ", descrizione=" + descrizione + ", superficie=" + superficie + ", numPopolazione=" + numPopolazione + '}';
    }

}
