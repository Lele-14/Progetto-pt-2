
import java.util.ArrayList;

public class Banca {
    private ArrayList<Utente> utenti = new ArrayList<Utente>(25);

    public boolean addUtente(Utente x) {

        for (int i = 0; i < utenti.size(); i = i + 1) {
            if (utenti.get(i).getCognome().equalsIgnoreCase(x.getCognome().trim())) {
                return false;
            }
        }

        return utenti.add(x);

    }

    public boolean removeUtente (String x) {
        
        if (utenti.isEmpty()) {
            return false;
        }

        for (int i=0; i<utenti.size(); i=i+1) {
            if (utenti.get(i).getCognome().equalsIgnoreCase(x.trim())) {
                
                return utenti.remove(utenti.get(i));
            }
        }

        return false;

    }


    public  void Prelievo (double conto, double wallet){
        if (conto > 0) {
            String x = "Inserire la somma di denaro che si desidera prelevare --> ";
            double prelievo = Input.leggiDouble(x);
            while (prelievo> conto) {
                System.out.println("ATTENZIONE! Non ci sono abbastanza soldi in banca. Scegliere una cifra piu' piccola.");
                prelievo = Input.leggiDouble(x);
            }
            /* conto = sommaDouble(conto, (prelievo * -1));
            conto = conto - prelievo;
            // wallet = sommaDouble(wallet, prelievo);
            wallet = wallet + prelievo;*/
            utenti.get(0).setContoBancario(conto + prelievo);
            utenti.get(0).setPortafoglio(wallet - prelievo);
        } else {
            System.out.println(
                    "ATTENZIONE! Il tuo conto corrente e' uguale o minore a 0 euro. Non ti e' permesso prelevare.");
        }
        
    }
    
    public  void Deposito (double conto, double wallet){
        if (conto > 0) {
            String x = "Inserire la somma di denaro che si desidera prelevare --> ";
            double deposito = Input.leggiDouble(x);
            while (deposito> conto) {
                System.out.println("ATTENZIONE! Non ci sono abbastanza soldi in banca. Scegliere una cifra piu' piccola.");
                deposito = Input.leggiDouble(x);
            }
           /* conto = sommaDouble(conto, (prelievo * -1));
            conto = conto + deposito;
            // wallet = sommaDouble(wallet, prelievo);
            wallet = wallet - deposito;*/
            utenti.get(0).setContoBancario(conto + deposito);
            utenti.get(0).setPortafoglio(wallet - deposito);
        } else {
            System.out.println(
                    "ATTENZIONE! Il tuo conto corrente e' uguale o minore a 0 euro. Non ti e' permesso prelevare.");
        }
        
    }


    

}