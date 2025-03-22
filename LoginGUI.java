
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame {

    private JTextField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private Banca bancaGestione;

    public LoginGUI(Banca gestioneInstance) {
        this.bancaGestione = gestioneInstance;

        setTitle("Login - Lele & Artur BANK");
        setSize(350, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Inserisci Password:"));
        passwordField = new JTextField();
        add(passwordField);

        loginButton = new JButton("Login");
        add(loginButton);

        statusLabel = new JLabel("");
        add(statusLabel);

        // Azione bottone
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();

                if (verificaCredenziali(password)) {
                    statusLabel.setText("Accesso riuscito!");
                    JOptionPane.showMessageDialog(null, "Benvenuto nella banca!");
                    // Qui puoi far partire il menu principale, o una nuova schermata
                    mostraMenu();
                } else {
                    statusLabel.setText("Password errata!");
                }
            }
        });
    }

    private boolean verificaCredenziali(String password) {
        int persona =  bancaGestione.findPersona(password);
        return persona != -1;
    }

    // Metodo per mostrare un semplice menu dopo login
    private void mostraMenu() {
        JFrame menuFrame = new JFrame("Menu Principale");
        menuFrame.setSize(300, 200);
        menuFrame.setLayout(new FlowLayout());
        menuFrame.add(new JLabel("Benvenuto nel Menu Principale!"));
        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Istanziazione del sistema di gestione
        gestione gestioneInstance = new gestione();
        SwingUtilities.invokeLater(() -> new LoginGUI(gestioneInstance).setVisible(true));
    }
}

