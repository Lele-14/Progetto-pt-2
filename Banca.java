
import java.util.ArrayList;

public class Banca {
    private String nome;
    private ArrayList<Utente> utenti = new ArrayList<Utente>(25);

    public Banca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean addUtente(Utente x) {

        for (int i = 0; i < utenti.size(); i = i + 1) {
            if (utenti.get(i).getPassword().equalsIgnoreCase(x.getPassword())) {
                return false;
            }
        }

        return utenti.add(x);

    }

    public boolean removeUtente(String x) {

        if (utenti.isEmpty()) {
            return false;
        }

        for (int i = 0; i < utenti.size(); i = i + 1) {
            if (utenti.get(i).getCognome().equalsIgnoreCase(x.trim())) {

                return utenti.remove(utenti.get(i));
            }
        }

        return false;

    }

    public int findPersona (String passwordInserita) {
        int persona = -1;
        for (int i = 0; i < utenti.size(); i++) {
            if (utenti.get(i).getPassword().equals(passwordInserita)) {
                persona = i;
                return persona;
            }
        }
        return persona;

    }

    public Utente getUtente(int index) {
        return utenti.get(index);
    }

    public boolean disponibilitaAzioni (double parametro, double risorsa) {
        if (risorsa <= 0 || parametro > risorsa) {
            return false;
        }
        return true;
    }


    public boolean Prelievo(double prelievo, String passwordInserita, int persona) {
        
        if (utenti.isEmpty() || persona==-1) {
            return false;
        }
            if (!disponibilitaAzioni(prelievo, utenti.get(persona).getContoBancario())) {
                return false;
            } else {
                utenti.get(persona).setPortafoglio(utenti.get(persona).getPortafoglio() + prelievo);
                utenti.get(persona).setContoBancario(utenti.get(persona).getContoBancario() - prelievo);
                return true;
            }
        
       
    }

    public boolean Deposito(double deposito, String passwordInserita) {
        int persona=findPersona(passwordInserita);
        if (utenti.isEmpty() || persona==-1) {
            return false;
        }
      
        if (!disponibilitaAzioni(deposito, utenti.get(persona).getPortafoglio())) {
            return false;
        }
        
            utenti.get(persona).setContoBancario(utenti.get(persona).getContoBancario() + deposito);
            utenti.get(persona).setPortafoglio(utenti.get(persona).getPortafoglio() - deposito);
            return true;
       

    }

    public  double Investimento (double quotaInvestimento, String passwordInserita, int grandezzaRischio) {
        double guadagno=-1;
         int persona=findPersona(passwordInserita);
        if (utenti.isEmpty() || persona==-1) {
            return guadagno;
        } else {
        if (disponibilitaAzioni(quotaInvestimento, utenti.get(persona).getContoBancario())) {
            int rischio = (int) (Math.random() * grandezzaRischio);
            if (rischio <= 50) {
                guadagno = (quotaInvestimento * (grandezzaRischio / 20.0));
            } else {
                guadagno = (double) ((20.0 / grandezzaRischio) * quotaInvestimento);
            }
            
            
        }
    }
        return guadagno;
    }



    public double investimento(double quotaInvestimento, String passwordInserita, int grandezzaRischio) {
        double guadagno = -1; // Valore predefinito per indicare un errore
    
        // Trova l'utente basandosi sulla password
        int persona = findPersona(passwordInserita);
        
        // Controllo per evitare errori
        if (utenti.isEmpty() || persona == -1) {
            return guadagno;
        }
    
        // Recupera il conto bancario dell'utente trovato
        double contoBancario = utenti.get(persona).getContoBancario();
    
        // Controlla se l'utente ha abbastanza fondi
        if (!disponibilitaAzioni(quotaInvestimento, contoBancario)) {
            return guadagno;
        }
    
        // Genera un valore di rischio tra 0 e grandezzaRischio
        int rischio = (int) (Math.random() * (grandezzaRischio + 1));
    
        // Determina il guadagno in base al rischio
        if (rischio <= 50) {
            guadagno = quotaInvestimento * (grandezzaRischio / 20.0);
        } else {
            guadagno = (20.0 / grandezzaRischio) * quotaInvestimento;
        }
    
        return guadagno;
    }
    


}