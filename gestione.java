public class gestione {

    public static void assegnaMesi(String mesi[]) {
        mesi[0] = "Gennaio";
        mesi[1] = "Febbraio";
        mesi[2] = "Marzo";
        mesi[3] = "Aprile";
        mesi[4] = "Maggio";
        mesi[5] = "Giugno";
        mesi[6] = "Luglio";
        mesi[7] = "Agosto";
        mesi[8] = "Settembre";
        mesi[9] = "Ottobre";
        mesi[10] = "Novembre";
        mesi[11] = "Dicembre";
    }

    public static String logIn() {
        System.out.println("Inserisci la tua password --> ");
        String password = Input.leggiString();
        return password;
    }

    public static Utente LoadUtente() {
        String nome, cognome, password;
        double portafoglio, contoBancario;
        int eta;
        System.out.println("Inserisci il nome --> ");
        nome = Input.leggiString();
        System.out.println("Inserisci il cognome --> ");
        cognome = Input.leggiString();
        System.out.println("Inserisci la password --> ");
        password = Input.leggiString();

        System.out.println("Inserisci l'età --> ");
        eta = (int) Input.leggiIntero(Input.leggiString());
        while (eta < 18 || eta > 100) {
            System.out.println("Attenzione. Eta' compresa tra 18 e 100 anni. Reinserisci l'età --> ");
            eta = (int) Input.leggiIntero(Input.leggiString());
        }
        System.out.println("Inserisci il tuo conto in portafoglio --> ");
        portafoglio = Input.leggiDouble(Input.leggiString());

        while (portafoglio < 0 || portafoglio > 1000000) {
            System.out.println(
                    "Attenzione. Il tuo conto in portafoglio deve essere compreso tra 0 e 1000000 euro. Reinserisci il tuo conto -->");
            portafoglio = Input.leggiDouble(Input.leggiString());
        }
        System.out.println("Inserisci il tuo conto bancario --> ");
        contoBancario = Input.leggiDouble(Input.leggiString());
        while (contoBancario < 0 || portafoglio > 1000000) {
            System.out.println(
                    "Attenzione. Il tuo conto in banca deve essere compreso tra 0 e 1000000 euro. Reinserisci il tuo conto -->");
            portafoglio = Input.leggiDouble(Input.leggiString());
        }

        Utente utente = new Utente(nome, cognome, eta, password, portafoglio, contoBancario);
        return utente;
    }

    public static void main(String[] args) {
        Utente u = new Utente("Franco", "Mussolini", 11, "Dante", 1110, 1000000);
        System.out.println(u.toString());
        Banca banca = new Banca("Tonolo & Ceaglei BANK");
        banca.addUtente(u);
        double g = banca.Investimento(12, "Dante", 1000);
        System.out.println(g);

        Menu menu = new Menu();
        String password;
        int ch = -1;

        do {
            menu.menu1();
            System.out.print("Fai la tua scelta --> ");
            ch = (int) Input.leggiIntero(Input.leggiString());
            while (ch < 0 || ch > 7) {
                System.out.print("Attenzione. Reinserire valori tra 0 e 7 --> ");
                ch = (int) Input.leggiIntero(Input.leggiString());
            }

            switch (ch) {
                case 1: {
                    System.out.println("1. Iscriviti");
                    Utente utente = LoadUtente();
                    if (banca.addUtente(utente)) {
                        System.out.println("Utente iscritto con successo");
                    } else {
                        System.out.println("Utente gia' presente");
                    }
                    break;

                }
                case 2: {
                    System.out.println("2. Accedi e visualizza");

                    password = logIn();
                    int persona = banca.findPersona(password);
                    if (persona != -1) {
                        System.out.println("BENVENUTO");
                        System.out.println(banca.getUtente(persona).toString());
                    }
                    break;

                }
                case 3: {
                    
                    System.out.println("3)Deposita il denaro");

                    password = logIn();
                    if (banca.findPersona(password) == -1) {
                        System.out.println("Persona non trovata");
                        break;
                    }
                    System.out.print("Inserire la quota che vuoi depositare --> ");
                    double deposito=Input.leggiDouble(Input.leggiString());
                    while (deposito<0 || deposito> banca.getUtente(banca.findPersona(password)).getPortafoglio()) {
                        System.out.print("ATTENZIONE!!! Reinserire la quota che vuoi depositare --> ");
                        deposito=Input.leggiDouble(Input.leggiString());
                    }
                    if (banca.Deposito(deposito, password)) {
                        System.out.println("Deposito avvenuto con successo");
                    } else {
                        System.out.println("Deposito NON avvenuto con successo");
                    }
                    break;

                }
                case 4: {
                    System.out.println("4)Preleva il denaro");
                    password = logIn();
                    if (banca.findPersona(password) == -1) {
                        System.out.println("Persona non trovata");
                        break;
                    }
                    if (banca.Prelievo(g, password, ch)) {
                        
                    }
                    break;
                }
                case 5: {
                    double guadagno = -1;
                    int contatoriMesi;
                    System.out.println("5)Investi del denaro\n");
                    password = logIn();
                    if (banca.findPersona(password) == -1) {
                        System.out.println("Impossibile investire. Password errata");
                        break;
                    }
                    menu.menu2();
                    ch = (int) Input.leggiIntero(Input.leggiString());
                    while (ch < 0 || ch > 3) {
                        System.out.print("Attenzione. Reinserire valori tra 0 e 3 --> ");
                        ch = (int) Input.leggiIntero(Input.leggiString());
                    }

                    switch (ch) {
                        case 1: {
                            contatoriMesi = 1;
                            break;
                        }

                        case 2: {

                            break;
                        }

                        case 3: {

                            break;
                        }

                        case 0: {

                            break;
                        }

                    }

                    menu.menu3();
                    ch = (int) Input.leggiIntero(Input.leggiString());
                    while (ch < 0 || ch > 3) {
                        System.out.print("Attenzione. Reinserire valori tra 0 e 3 --> ");
                        ch = (int) Input.leggiIntero(Input.leggiString());
                    }
                    double quotaInvestimento = Input.leggiDouble(Input.leggiString());
                    switch (ch) {
                        case 1: {
                            guadagno = banca.Investimento(quotaInvestimento, password, 100);
                            break;
                        }

                        case 2: {
                            guadagno = banca.Investimento(quotaInvestimento, password, 250);
                            break;
                        }

                        case 3: {
                            guadagno = banca.Investimento(quotaInvestimento, password, 500);
                            break;
                        }

                        case 0: {

                            break;
                        }

                    }
                    if (guadagno > quotaInvestimento) {
                        System.out.println("Investimento andato a buon fine!!!");
                    } else {
                        System.out.println("Investimento NON andato a buon fine!!!");
                    }
                    banca.getUtente(banca.findPersona(password)).setContoBancario(
                            banca.getUtente(banca.findPersona(password)).getContoBancario() + guadagno);
                    break;
                }
                case 6: {
                    password = logIn();
                    banca.getUtente(banca.findPersona(password)).setPortafoglio(banca.getUtente(banca.findPersona(password)).getPortafoglio() + 100);
                    break;
                }
                case 0: {
                    System.out.println("6)Vai al mese successivo");
                    System.out.println("Arrivederci");
                }
            }

        } while (ch != 0);
    }
}