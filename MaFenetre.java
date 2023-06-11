
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MaFenetre extends JFrame implements ActionListener {

    // Déclaration et instanciation d’un attribut de typeJPanel
    private JPanel panel = new JPanel();
    private JLabel labelLogin = new JLabel("Login");
    private JLabel labelPassword = new JLabel("Password");
    private JTextField textFieldLogin = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton buttonConnexion = new JButton("Connexion");

    // Constructeur de la classe Fenetre
    public MaFenetre() {
        this.setTitle("Ma première fenêtre");
        this.setSize(500, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on cliquant sur le croix la fenetre va etre fermée
        this.setVisible(true);// la fenetre est par defaut est invisible
        this.panel.setBackground(Color.pink);
        // On prévient notre JFrame que notre JPanel sera son content panel
        this.setContentPane(panel); // Le gestionnaire de placement par défaut utilisé par JPanel est le FlowLayout.

        // solution pour obtenir la disposition demandé
        panel.setLayout(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(labelLogin);
        panel.add(textFieldLogin);
        panel.add(labelPassword);
        panel.add(passwordField);
        panel.add(new JLabel()); // une label vide pour l'espacement
        panel.add(buttonConnexion);

        buttonConnexion.addActionListener(this);

    }

    public boolean authentification(String login, char[] password) {
        String pwd = new String(password);
        if (login.equals("admin") && pwd.equals("adminpwd")) {
            return true;
        } else
            return false;
    }

    public void actionPerformed(ActionEvent e) {
        if (authentification(textFieldLogin.getText(), passwordField.getPassword())) {
            JOptionPane.showMessageDialog(panel, "Bienvenue! " + textFieldLogin.getText(),
                    "Confirmation de connexion", JOptionPane.INFORMATION_MESSAGE);
                    FenetreGestionEtudiant fenetre = new FenetreGestionEtudiant();
                    fenetre.setVisible(true);
                    dispose();
        }

        else {
            JOptionPane.showMessageDialog(panel, "error");
        }
    }

}
