package IHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import control.OeuvreControl;
import control.UsagerControl;
import objets_metiers.Oeuvre;
import objets_metiers.Usager;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class GestionUtilisateur extends JInternalFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUtilisateur frame = new GestionUtilisateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GestionUtilisateur() {
		getContentPane().setBackground(new Color(119, 136, 153));
		setBounds(0, 0, 789, 645);
		setVisible(true);
		getContentPane().setLayout(null);
		
		JPanel panListeOeuvre = new JPanel();
		panListeOeuvre.setBorder(BorderFactory.createTitledBorder("Information Personelle"));
		panListeOeuvre.setBackground(new Color(119, 136, 153));
		panListeOeuvre.setBounds(10, 37, 751, 231);
		getContentPane().add(panListeOeuvre);
		
		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setBounds(27, 27, 113, 22);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(382, 27, 113, 22);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setBounds(499, 29, 190, 20);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom");
		lblNewLabel_2.setBounds(27, 86, 113, 22);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 88, 190, 20);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse");
		lblNewLabel_3.setBounds(382, 88, 113, 22);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		textField_3 = new JTextField();
		textField_3.setBounds(499, 90, 190, 20);
		textField_3.setColumns(10);
		
		JComboBox cmbTitle = new JComboBox();
		cmbTitle.setBounds(144, 28, 190, 22);
		cmbTitle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr", "Mme"}));
		JLabel lblNewLabel_2_1 = new JLabel("Telephone");
		lblNewLabel_2_1.setBounds(27, 137, 113, 22);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setBounds(144, 139, 190, 20);
		textField.setColumns(10);
		panListeOeuvre.setLayout(null);
		panListeOeuvre.add(lblNewLabel_2_1);
		panListeOeuvre.add(textField);
		panListeOeuvre.add(lblNewLabel_2);
		panListeOeuvre.add(textField_2);
		panListeOeuvre.add(lblNewLabel);
		panListeOeuvre.add(cmbTitle);
		panListeOeuvre.add(lblNewLabel_1);
		panListeOeuvre.add(textField_1);
		panListeOeuvre.add(lblNewLabel_3);
		panListeOeuvre.add(textField_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Date Naissance");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(382, 137, 113, 22);
		panListeOeuvre.add(lblNewLabel_2_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(499, 139, 190, 20);
		panListeOeuvre.add(textField_4);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(48, 177, 641, 43);
		panListeOeuvre.add(panel);
		
		JButton ajouterBouton = new JButton();
		ajouterBouton.setText("Ajouter");
		ajouterBouton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ajouterBouton.setAlignmentY(1.0f);
		ajouterBouton.setAlignmentX(1.0f);
		ajouterBouton.setBounds(51, 11, 93, 29);
		panel.add(ajouterBouton);
		
		JButton modifierBouton = new JButton();
		modifierBouton.setText("Modifier");
		modifierBouton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		modifierBouton.setEnabled(false);
		modifierBouton.setBounds(176, 11, 101, 29);
		panel.add(modifierBouton);
		
		JButton supprimerButton = new JButton();
		supprimerButton.setText("Supprimer");
		supprimerButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		supprimerButton.setEnabled(false);
		supprimerButton.setBounds(337, 11, 117, 29);
		panel.add(supprimerButton);
		
		JButton exemplaireButton = new JButton();
		exemplaireButton.setText("Exemplaire");
		exemplaireButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		exemplaireButton.setEnabled(false);
		exemplaireButton.setBounds(493, 11, 121, 29);
		panel.add(exemplaireButton);
		
		JPanel panListeOeuvre_1 = new JPanel();
		panListeOeuvre_1.setBorder(BorderFactory.createTitledBorder("Liste des Oeuvres"));
		panListeOeuvre_1.setBackground(new Color(119, 136, 153));
		panListeOeuvre_1.setBounds(10, 301, 751, 268);
		getContentPane().add(panListeOeuvre_1);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBackground(Color.WHITE);
		GroupLayout gl_panListeOeuvre_1 = new GroupLayout(panListeOeuvre_1);
		gl_panListeOeuvre_1.setHorizontalGroup(
			gl_panListeOeuvre_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panListeOeuvre_1.createSequentialGroup()
					.addGap(24)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 648, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		gl_panListeOeuvre_1.setVerticalGroup(
			gl_panListeOeuvre_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panListeOeuvre_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nom", "Prenom", "DateNaissance", "Sexe", "Telephone", "Adresse"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
		jScrollPane1.setViewportView(table);
		panListeOeuvre_1.setLayout(gl_panListeOeuvre_1);
		setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        listing();

	}
	private void listing(){
    	try {
    		UsagerControl userC= new UsagerControl();
        	ArrayList<Usager> allU= userC.getAll();
        	DefaultTableModel m=(DefaultTableModel)table.getModel();
        	m.setNumRows(0);
        	for(Usager o:allU)
        	    m.addRow(new Object[] {o.getId(),o.getNom(),o.getPrenom(),o.getDateNais(),o.getSexe(),o.getTel(),o.getAdresse()});	
    	} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	
    	}

}
