package IHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import Utility.BibalExceptions;
import Utility.ModelTableau;
import control.ExemplaireControl;
import control.OeuvreControl;
import control.TypeController;
import control.UsagerControl;
import objets_metiers.Exemplaire;
import objets_metiers.Oeuvre;
import objets_metiers.TypeOeuvre;
import objets_metiers.Usager;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;

public class GestionDesEmprunts extends JInternalFrame {
	private JTable table;
    private OeuvreControl ov;
    private JTextField txtDateNais;
    private JTextField txtAdr;
    private JTextField txtTelephone;
    private JComboBox cmbUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDesEmprunts frame = new GestionDesEmprunts();
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
	public GestionDesEmprunts() {
        getContentPane().setLayout(null);
     //   table.setModel(new DefaultTabme(new Object[0][0],
     //           new String[]{"ID", "Titre", "Auteur", "Catégorie", "Type", "Exemplaires", "Réservations"}));
      
		setBackground(new Color(47, 79, 79));
		setBounds(0, 0, 698, 534);
		setVisible(true);
		getContentPane().setLayout(null);
		setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);

       // setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bibliotheque_icone.png")));
        setVisible(true);
        setBorder(null);
       // listing();

		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 698, 534);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setLayout(null);
		panel_1.setBounds(23, 420, 641, 43);
		panel.add(panel_1);
		
		JButton btnEmprunter = new JButton();
		btnEmprunter.setText("Emprunter");
		btnEmprunter.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnEmprunter.setAlignmentY(1.0f);
		btnEmprunter.setAlignmentX(1.0f);
		btnEmprunter.setBounds(151, 11, 134, 29);
		panel_1.add(btnEmprunter);
		
		JButton ajouterBouton_1 = new JButton();
		ajouterBouton_1.setText("Rendre");
		ajouterBouton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ajouterBouton_1.setAlignmentY(1.0f);
		ajouterBouton_1.setAlignmentX(1.0f);
		ajouterBouton_1.setBounds(339, 11, 112, 29);
		panel_1.add(ajouterBouton_1);
		
		JPanel panListeOeuvre = new JPanel();
		panListeOeuvre.setBorder(BorderFactory.createTitledBorder("Liste des Oeuvres"));
		panListeOeuvre.setBackground(new Color(47, 79, 79));
		panListeOeuvre.setBounds(10, 166, 685, 231);
		panel.add(panListeOeuvre);
		
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.setBackground(Color.WHITE);
		GroupLayout gl_panListeOeuvre = new GroupLayout(panListeOeuvre);
		gl_panListeOeuvre.setHorizontalGroup(
			gl_panListeOeuvre.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 685, Short.MAX_VALUE)
				.addGroup(gl_panListeOeuvre.createSequentialGroup()
					.addContainerGap(61, Short.MAX_VALUE)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		gl_panListeOeuvre.setVerticalGroup(
			gl_panListeOeuvre.createParallelGroup(Alignment.LEADING)
				.addGap(0, 231, Short.MAX_VALUE)
				.addGroup(gl_panListeOeuvre.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		table = new JTable();
		jScrollPane1.setColumnHeaderView(table);
	       table.setModel(new DefaultTableModel(
	       	new Object[][] {
	       	},
	       	new String[] {
	       		"ID", "Titre", "Auteur", "Cat\u00E9gorie", "Type", "Exemplaires", "R\u00E9servations"
	       	}
	       ));
		panListeOeuvre.setLayout(gl_panListeOeuvre);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(13, 52, 675, 101);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Utilisateur");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(3, 11, 85, 14);
		panel_2.add(lblNewLabel);
		
	    cmbUser = new JComboBox();
	    cmbUser.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent e) {
	    		int index;
	    		String selectedItem=cmbUser.getSelectedItem().toString();
	    		Usager user=findUsager(selectedItem);
	    		SimpleDateFormat f=new SimpleDateFormat("yyyy-dd-MM");
	    		txtDateNais.setText(f.format(user.getDateNais()));
	    		txtAdr.setText(user.getAdresse());
	    		txtTelephone.setText(user.getTel());
	    		
	    	
	    	}
	    });
		cmbUser.setBounds(119, 8, 136, 22);
		panel_2.add(cmbUser);
		
		JLabel lblDateNaissance = new JLabel("Date Naissance");
		lblDateNaissance.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDateNaissance.setBounds(3, 58, 106, 14);
		panel_2.add(lblDateNaissance);
		
		txtDateNais = new JTextField();
		txtDateNais.setEditable(false);
		txtDateNais.setBounds(119, 56, 136, 20);
		panel_2.add(txtDateNais);
		txtDateNais.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAdresse.setBounds(372, 11, 106, 14);
		panel_2.add(lblAdresse);
		
		txtAdr = new JTextField();
		txtAdr.setEditable(false);
		txtAdr.setColumns(10);
		txtAdr.setBounds(469, 11, 196, 36);
		panel_2.add(txtAdr);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTelephone.setBounds(372, 58, 106, 14);
		panel_2.add(lblTelephone);
		
		txtTelephone = new JTextField();
		txtTelephone.setEditable(false);
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(468, 55, 196, 20);
		panel_2.add(txtTelephone);
		 listing();
		 fillCmb();
	}
   private void fillCmb() {
		UsagerControl ctrUser = new UsagerControl();
		ArrayList<Usager> tab;
		cmbUser.removeAllItems();
		tab=ctrUser.getAll();
		System.out.println(tab);
		for(Usager t:tab){
			cmbUser.addItem(t.getNom()+" "+t.getPrenom());
		}
   }
    private Usager findUsager(String user) {
    	UsagerControl ctrUser = new UsagerControl();
		ArrayList<Usager> tab=ctrUser.getAll();
		String nom;
		for(Usager u:tab) {
			nom=u.getNom()+" "+u.getPrenom();
			if(nom.equalsIgnoreCase(user))
				return u;
		}
		return null;
    }
    private void listing(){
    	try {
    		ov=new OeuvreControl();
        	ArrayList<Oeuvre> allOv= ov.getAll();
        	DefaultTableModel m=(DefaultTableModel)table.getModel();
        	m.setNumRows(0);
        	for(Oeuvre o:allOv)
        	    m.addRow(new Object[] {o.getId(),o.getTitre(),o.getAuteur(),o.getCategorie(),o.getType().getNom_Fr(),o.getNbExemplaire(),o.getNbResa()});	
    	} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	
    	}
}
