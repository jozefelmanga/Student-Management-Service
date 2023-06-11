import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetreGestionEtudiant extends JFrame implements ActionListener {

    private JTabbedPane onglets;
    private JPanel ongletListeEtudiants, ongletAjoutEtudiant, ongletModificationEtudiant, ongletSuppressionEtudiant;
    private JLabel L1 = new JLabel("Ajout Etudiant");
    private JLabel L2 = new JLabel("Cin");
    private JTextField T1 = new JTextField(15);
    private JLabel L3 = new JLabel("Nom");
    private JTextField T2 = new JTextField(15);
    private JLabel L4 = new JLabel("Prenom");
    private JTextField T3 = new JTextField(15);
    private JLabel L5 = new JLabel("Adresse");
    private JTextField T4 = new JTextField(15);
    private JButton btn1 = new JButton("Ajouter");

    private GestionEtudiant gestionEtudiant;

    private JLabel L21 = new JLabel("Cin");
    private JTextField T11 = new JTextField(15);
    private JLabel L31 = new JLabel("Nom");
    private JTextField T21 = new JTextField(15);
    private JLabel L41 = new JLabel("Prenom");
    private JTextField T31 = new JTextField(15);
    private JLabel L51 = new JLabel("Adresse");
    private JTextField T41 = new JTextField(15);
    private JLabel L6 = new JLabel("Selectionner un CIN:");
    private JComboBox CB1;
    private JButton btn2 = new JButton("Modifier");

    private JLabel L22 = new JLabel("Cin");
    private JTextField T12 = new JTextField(15);
    private JLabel L32 = new JLabel("Nom");
    private JTextField T22 = new JTextField(15);
    private JLabel L42 = new JLabel("Prenom");
    private JTextField T32 = new JTextField(15);
    private JLabel L52 = new JLabel("Adresse");
    private JTextField T42 = new JTextField(15);
    private JLabel L61 = new JLabel("Selectionner un CIN:");
    private JComboBox CB2;
    private JButton btn3 = new JButton("Supprimer");

    private SimpleTableModel model;

    public FenetreGestionEtudiant() {
        // Définition de la fenêtre principale
        setTitle("Gestion des étudiants");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création des onglets
        onglets = new JTabbedPane();

        ongletAjoutEtudiant = new JPanel();
        onglets.addTab("Ajout d'un étudiant", ongletAjoutEtudiant);

        ongletListeEtudiants = new JPanel();
        onglets.addTab("Liste des étudiants", ongletListeEtudiants);

        ongletModificationEtudiant = new JPanel();
        onglets.addTab("Modification d'un étudiant", ongletModificationEtudiant);

        ongletSuppressionEtudiant = new JPanel();
        onglets.addTab("Suppression d'un étudiant", ongletSuppressionEtudiant);

        // Ajout des onglets à la fenêtre principale
        add(onglets);

        initOngletListeEtudiants();
        initOngletAjoutEtudiant();
        initOngletModifierEtudiant();
        initOngletDeleteEtudiant();
    }

    public static void main(String[] args) {
        FenetreGestionEtudiant fenetre = new FenetreGestionEtudiant();
        fenetre.setVisible(true);
    }

    public void initOngletAjoutEtudiant() {
        GridBagLayout layout = new GridBagLayout();
        ongletAjoutEtudiant.setLayout(layout);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        ongletAjoutEtudiant.add(L1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ongletAjoutEtudiant.add(L2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        ongletAjoutEtudiant.add(T1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        ongletAjoutEtudiant.add(L3, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        ongletAjoutEtudiant.add(T2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        ongletAjoutEtudiant.add(L4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        ongletAjoutEtudiant.add(T3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        ongletAjoutEtudiant.add(L5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        ongletAjoutEtudiant.add(T4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        btn1.setPreferredSize(new Dimension(170, 20));
        ongletAjoutEtudiant.add(btn1, gbc);

        btn1.addActionListener(this);
    }

    public void initOngletListeEtudiants() {
        gestionEtudiant = new GestionEtudiant();
        model = new SimpleTableModel(gestionEtudiant.getEtudiants());
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        ongletListeEtudiants.add(scrollPane);
    }

    public void initOngletModifierEtudiant() {
        GridBagLayout layout = new GridBagLayout();
        ongletModificationEtudiant.setLayout(layout);
        CB1 = new JComboBox<Integer>(getListCin());
        CB1.setSelectedIndex(-1);
        CB1.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; 
        ongletModificationEtudiant.add(L6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1; 
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        CB1.setPreferredSize(new Dimension(170, 20));
        ongletModificationEtudiant.add(CB1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ongletModificationEtudiant.add(L21, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        ongletModificationEtudiant.add(T11, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        ongletModificationEtudiant.add(L31, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        ongletModificationEtudiant.add(T21, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        ongletModificationEtudiant.add(L41, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        ongletModificationEtudiant.add(T31, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        ongletModificationEtudiant.add(L51, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        ongletModificationEtudiant.add(T41, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        btn2.setPreferredSize(new Dimension(170, 20));
        ongletModificationEtudiant.add(btn2, gbc);

        btn2.addActionListener(this);
    }

    public void initOngletDeleteEtudiant() {
        GridBagLayout layout = new GridBagLayout();
        ongletSuppressionEtudiant.setLayout(layout);

        CB2 = new JComboBox<Integer>(getListCin());
        CB2.setSelectedIndex(-1);
        CB2.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        ongletSuppressionEtudiant.add(L61, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        CB2.setPreferredSize(new Dimension(170, 20));
        ongletSuppressionEtudiant.add(CB2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        ongletSuppressionEtudiant.add(L22, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        ongletSuppressionEtudiant.add(T12, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        ongletSuppressionEtudiant.add(L32, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        ongletSuppressionEtudiant.add(T22, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        ongletSuppressionEtudiant.add(L42, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        ongletSuppressionEtudiant.add(T32, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        ongletSuppressionEtudiant.add(L52, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        ongletSuppressionEtudiant.add(T42, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        btn3.setPreferredSize(new Dimension(170, 20));
        ongletSuppressionEtudiant.add(btn3, gbc);

        T12.setEditable(false);
        T22.setEditable(false);
        T32.setEditable(false);
        T42.setEditable(false);
        btn3.addActionListener(this);
    }

    public Integer[] getListCin() {
        Integer[] tab = new Integer[gestionEtudiant.getEtudiants().size()];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = gestionEtudiant.getEtudiants().get(i).getCin();
        }
        return tab;
    }

    public void viderChamp(JTextField tf) {
        tf.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            if (T1.getText().isEmpty() || T2.getText().isEmpty() ||
                    T3.getText().isEmpty() || T4.getText().isEmpty()) {
                JOptionPane.showMessageDialog(ongletAjoutEtudiant, "Champs de saisie invalides!",
                        "Echec d'ajout", JOptionPane.ERROR_MESSAGE);
            } else {
                Etudiant etudiant = new Etudiant(Integer.parseInt(T1.getText()), T2.getText(), T3.getText(),
                        T4.getText());
                if (gestionEtudiant.addEtudiant(etudiant)) {
                    JOptionPane.showMessageDialog(ongletAjoutEtudiant, "Etudiant ajouté avec succès!");

                    // Update JTable
                    // model.fireTableDataChanged();
                    ongletListeEtudiants.removeAll();
                    model = new SimpleTableModel(gestionEtudiant.getEtudiants());
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    ongletListeEtudiants.add(scrollPane);

                    DefaultComboBoxModel m1 = new DefaultComboBoxModel<>();
                    DefaultComboBoxModel m2 = new DefaultComboBoxModel<>();

                    for (int i = 0; i < getListCin().length; i++) {
                        m1.addElement(getListCin()[i]);
                        m2.addElement(getListCin()[i]);
                    }
                    CB1.setModel(m1);
                    CB2.setModel(m2);

                } else {
                    JOptionPane.showMessageDialog(ongletAjoutEtudiant, "Erreur lors de l'ajout!");
                }
            }
        }

        if (e.getSource() == CB1) {
            Integer currentCin = (Integer) CB1.getSelectedItem();
            Etudiant et = gestionEtudiant.getEtudiantByCin(currentCin);
            T11.setText(Integer.toString(et.getCin()));
            T21.setText(et.getNom());
            T31.setText(et.getPrenom());
            T41.setText(et.getAdresse());
        }

        if (e.getSource() == btn2) {
            if (T11.getText().isEmpty() || T21.getText().isEmpty() ||
                    T31.getText().isEmpty() || T41.getText().isEmpty()) {
                JOptionPane.showMessageDialog(ongletModificationEtudiant, "Champs de saisie invalides!",
                        "Echec de modification", JOptionPane.ERROR_MESSAGE);
            } else {
                Etudiant etudiant = new Etudiant(Integer.parseInt(T11.getText()), T21.getText(), T31.getText(),
                        T41.getText());
                if (gestionEtudiant.updateEtudiant(etudiant)) {
                    JOptionPane.showMessageDialog(ongletModificationEtudiant, "Etudiant modifie avec succès!");
                    // Update JTable
                    // model.fireTableDataChanged();
                    ongletListeEtudiants.removeAll();
                    model = new SimpleTableModel(gestionEtudiant.getEtudiants());
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    ongletListeEtudiants.add(scrollPane);
                } else {
                    JOptionPane.showMessageDialog(ongletModificationEtudiant, "Erreur lors du modification!");
                }
            }
        }

        if (e.getSource() == CB2) {
            Integer currentCin = (Integer) CB2.getSelectedItem();
            Etudiant et = gestionEtudiant.getEtudiantByCin(currentCin);
            T12.setText(Integer.toString(et.getCin()));
            T22.setText(et.getNom());
            T32.setText(et.getPrenom());
            T42.setText(et.getAdresse());
        }

        if (e.getSource() == btn3) {
            int reponse = JOptionPane.showConfirmDialog(ongletSuppressionEtudiant,
                    "Etes vous sûr de vouloir supprimmer cet etudiant?",
                    "Confirmation de delete",
                    JOptionPane.YES_NO_OPTION);
            if (reponse == JOptionPane.OK_OPTION) {
                Etudiant etudiant = new Etudiant(Integer.parseInt(T12.getText()), T22.getText(), T32.getText(),
                        T42.getText());
                if (gestionEtudiant.deleteEtudiant(etudiant.getCin())) {
                    JOptionPane.showMessageDialog(ongletSuppressionEtudiant, "Suppression effectuee avec succès!");
                    viderChamp(T12);
                    viderChamp(T22);
                    viderChamp(T32);
                    viderChamp(T42);
                    // Update JTable
                    // model.fireTableDataChanged();
                    ongletListeEtudiants.removeAll();
                    model = new SimpleTableModel(gestionEtudiant.getEtudiants());
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    ongletListeEtudiants.add(scrollPane);

                    CB2.removeItem(etudiant.getCin());
                    CB1.removeItem(etudiant.getCin());

                } else {
                    JOptionPane.showMessageDialog(ongletSuppressionEtudiant, "Erreur lors du suppression!");
                }
            }
        }
    }

}
