
import control.Stato;

/**
 *
 * @author Admin
 */
public class App {

    static String regioniFile = "data/regioni.csv";
    static String provinceFile = "data/province.csv";
    static String comuniFile = "data/comuni.csv";

    public static void main(String[] args) {

        Stato Italia = new Stato(regioniFile, provinceFile, comuniFile);

        Italia.stampaComune("Bologna");
        Italia.stampaComuni("Emilia Romagna");
        Italia.stampaProvince("Emilia Romagna");
        Italia.stampaPopolazione("Emilia Romagna");
        Italia.stampaSuperficie("Emilia Romagna");

    }

}
