import java.util.Scanner;

public class Input {
    public double leggiDouble(String x) {
        Scanner input = new Scanner(System.in);
        double d = 0;
        String stringa;
        boolean ok;
        do {
            ok = true;
            System.out.print(x);
            stringa = input.nextLine();
            System.out.print("\n");
            try {
                d = Double.parseDouble(stringa);
            } catch (NumberFormatException e) {
                ok = false;
                System.out.println("ERRORE! Formato non valido. Reinserire");
            }

            if (ok) {
                if (d < 0) {
                    ok = false;
                    System.out.println("ERRORE! Valore non valido. Reinserire");
                }
            }
        } while (!ok);
        return d;
    }
}
