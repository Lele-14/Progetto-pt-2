import java.util.Scanner;

public class Menu {


    /**
     * Mostra il menu principale con le opzioni disponibili per la gestione del
     * conto.
     */
    public static void menu1() {
        System.out.println("***Scegli l'opzione***\n");
        System.out.println("1)Preleva il denaro");
        System.out.println("2)Deposita il denaro");
        System.out.println("3)Investi del denaro\n");
        System.out.println("0)ESCI e vai al mese successivo");
        System.out.println("---> ");
    }

    /**
     * Mostra il menu per scegliere la durata dell'investimento.
     */

    private void menu2() {
        System.out.println("****INVESTIMENTO****");
        System.out.println("***Scegli la durata***\n");
        System.out.println("1)Breve (Mensile)");
        System.out.println("2)Media (Trimestrale)");
        System.out.println("3)Lunga (Semestrale)\n");
        System.out.println("0)ANNULLA");
        System.out.println("---> ");
    }

    /**
     * Mostra il menu per scegliere il livello di rischio e guadagno
     * dell'investimento.
     */

    private void menu3() {
        System.out.println("****INVESTIMENTO****");
        System.out.println("***Scegli il rischio e il guadagno***\n");
        System.out.println("1)Basso rischio e basso guadagno");
        System.out.println("2)Medio rischio e medio guadagno");
        System.out.println("3)Alto rischio e alto guadagno\n");
        System.out.println("0)ANNULLA");
        System.out.println("---> ");
    }


    public int scelta(int x) {
        Scanner input = new Scanner(System.in);
        int scelta = 10;
        String stringa;
        boolean ok;
        do {
            switch (x) {

                case 1: {
                    menu1();
                    break;
                }

                case 2: {
                    menu2();
                    break;
                }

                case 3: {
                    menu3();
                    break;
                }

            }
            stringa = input.nextLine();
            ok = true;
            try {
                scelta = Integer.parseInt(stringa);
            } catch (NumberFormatException e) {
                ok = false;
                System.out.println("ERRORE! Formato non valido. Reinserire");
            }
            if (ok) {
                if (scelta < 0 || scelta > 3) {
                    ok = false;
                    System.out.println("ERRORE! Valore non valido. Reinserire");
                }
            }
        } while (!ok);
        return scelta;
    }

}
