package control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import model.Comune;
import model.Provincia;
import model.Regione;

/**
 *
 * @author Admin
 */
public class Stato {

    private HashMap<Integer, Regione> regioni;
    private HashMap<Integer, Provincia> province;
    private HashMap<String, Comune> comuni;

    public Stato(String regioniFile, String provinceFile, String comuniFile) {
        regioni = new HashMap<>();
        province = new HashMap<>();
        comuni = new HashMap<>();
        caricaRegioni(regioniFile);
        caricaProvince(provinceFile);
        caricaComuni(comuniFile);
    }

    private boolean caricaRegioni(String regioniFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(regioniFile));
            String s;
            while ((s = br.readLine()) != null) {
                String[] ss = s.split(";");
                Regione regione = new Regione(Integer.valueOf(ss[0]), ss[1]);
                regioni.put(regione.getCodiceRegione(), regione);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException ex) {
            System.out.println("Errore I/O");
        }
        return true;
    }

    private boolean caricaProvince(String provinceFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(provinceFile));
            String s;
            while ((s = br.readLine()) != null) {
                String[] ss = s.split(";");
                Provincia provincia = new Provincia(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]), ss[2], ss[3]);
                province.put(provincia.getCodProvincia(), provincia);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException ex) {
            System.out.println("Errore I/O");
        }
        return true;
    }

    private boolean caricaComuni(String comuniFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(comuniFile));
            String s;
            while ((s = br.readLine()) != null) {
                String[] ss = s.split(";");
                Comune comune = new Comune(Integer.valueOf(ss[0]), Integer.valueOf(ss[1]), ss[2], ss[3], Float.valueOf(ss[4]), Integer.valueOf(ss[5]));
                comuni.put(comune.getIstat(), comune);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        } catch (IOException ex) {
            System.out.println("Errore I/O");
        }
        return true;
    }

    public void stampaComune(String nomeComune) {
        for (Map.Entry<String, Comune> entry : comuni.entrySet()) {
            Comune value = entry.getValue();
            if (value.getDescrizione().equals(nomeComune)) {
                System.out.println("Comune di: " + nomeComune);
                System.out.println(value.toString());
            }
        }
        System.out.println("-------------------------------------");
    }

    public void stampaComuni(String nomeRegione) {
        int codiceRegione = 0;
        for (Map.Entry<Integer, Regione> entry : regioni.entrySet()) {
            Regione value = entry.getValue();
            if (value.getDescrizione().equals(nomeRegione)) {
                codiceRegione = value.getCodiceRegione();
            }
        }
        System.out.println("Comuni di: " + nomeRegione);
        for (Map.Entry<String, Comune> entry : comuni.entrySet()) {
            Comune value = entry.getValue();
            if (value.getCodRegione() == codiceRegione) {
                System.out.println(value.toString());
            }
        }
        System.out.println("-------------------------------------");
    }

    public void stampaProvince(String nomeRegione) {
        int codiceRegione = 0;
        for (Map.Entry<Integer, Regione> entry : regioni.entrySet()) {
            Regione value = entry.getValue();
            if (value.getDescrizione().equals(nomeRegione)) {
                codiceRegione = value.getCodiceRegione();
            }
        }
        System.out.println("Province in: " + nomeRegione);
        for (Map.Entry<Integer, Provincia> entry : province.entrySet()) {
            Provincia value = entry.getValue();
            if (codiceRegione == value.getCodRegione()) {
                System.out.println(value.getDescrizione());
            }
        }
        System.out.println("-------------------------------------");
    }

    public void stampaPopolazione(String nomeRegione) {
        int codiceRegione = 0;
        int sommaPopolazione = 0;
        for (Map.Entry<Integer, Regione> entry : regioni.entrySet()) {
            Regione value = entry.getValue();
            if (value.getDescrizione().equals(nomeRegione)) {
                codiceRegione = value.getCodiceRegione();
            }
        }
        for (Map.Entry<String, Comune> entry : comuni.entrySet()) {
            Comune value = entry.getValue();
            if (value.getCodRegione() == codiceRegione) {
                sommaPopolazione += value.getNumPopolazione();
            }
        }
        System.out.println(nomeRegione + ": " + sommaPopolazione + " abitanti");
        System.out.println("-------------------------------------");
    }

    public void stampaSuperficie(String nomeRegione) {
        int codiceRegione = 0;
        int sommaSuperficie = 0;
        for (Map.Entry<Integer, Regione> entry : regioni.entrySet()) {
            Regione value = entry.getValue();
            if (value.getDescrizione().equals(nomeRegione)) {
                codiceRegione = value.getCodiceRegione();
            }
        }
        for (Map.Entry<String, Comune> entry : comuni.entrySet()) {
            Comune comune = entry.getValue();
            if (comune.getCodRegione() == codiceRegione) {
                sommaSuperficie += comune.getSuperficie();
            }
        }
        System.out.println(nomeRegione + ": " + sommaSuperficie + " km²");
        System.out.println("-------------------------------------");
    }
}
