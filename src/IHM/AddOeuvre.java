package IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

import control.OeuvreControl;
import control.TypeController;
import objets_metiers.Oeuvre;
import objets_metiers.TypeOeuvre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddOeuvre extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitre;
	private JTextField txtAuteur;
	private JTextField txtCat;
	private JComboBox cmbType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOeuvre frame = new AddOeuvre();
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
	public AddOeuvre() {

		setUndecorated(true);
		setEnabled(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(817, 345, -807, -346);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 263, 787, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton cmdCon = new JButton("Ajouter");
		cmdCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeController tc=new TypeController();
				OeuvreControl oc=new OeuvreControl();
				Oeuvre o=new Oeuvre(txtTitre.getText(),txtAuteur.getText(),txtCat.getText(),0,0,0,tc.getByNom(cmbType.getSelectedItem().toString()));
			   if(oc.insert(o))
				   JOptionPane.showMessageDialog(null,"Ajout Avec Succées");
			   else
				   JOptionPane.showMessageDialog(null,"Echec");
			}
		});
		cmdCon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmdCon.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		cmdCon.setBackground(Color.WHITE);
		cmdCon.setBounds(206, 11, 144, 31);
		panel_1.add(cmdCon);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAnnuler.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		btnAnnuler.setBackground(Color.WHITE);
		btnAnnuler.setBounds(438, 11, 144, 31);
		panel_1.add(btnAnnuler);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setForeground(new Color(95, 158, 160));
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(10, 11, 787, 32);
		contentPane.add(panel_2);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
			}
		});

		lblClose.setVerticalAlignment(SwingConstants.TOP);
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setForeground(Color.LIGHT_GRAY);
		lblClose.setFont(new Font("Sitka Heading", Font.BOLD, 27));
		lblClose.setBackground(Color.GRAY);
		lblClose.setBounds(760, 0, 17, 21);
		panel_2.add(lblClose);
		
		JLabel lbltitre = new JLabel("Titre");
		lbltitre.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbltitre.setBounds(45, 79, 90, 32);
		contentPane.add(lbltitre);
		
		 cmbType = new JComboBox();
		cmbType.setBounds(562, 193, 197, 32);
		contentPane.add(cmbType);
		
		txtTitre = new JTextField();
		txtTitre.setBounds(157, 80, 197, 32);
		contentPane.add(txtTitre);
		txtTitre.setColumns(10);
		
		JLabel lbltitre_1 = new JLabel("Type");
		lbltitre_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbltitre_1.setBounds(450, 189, 90, 32);
		contentPane.add(lbltitre_1);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAuteur.setBounds(450, 79, 90, 32);
		contentPane.add(lblAuteur);
		
		txtAuteur = new JTextField();
		txtAuteur.setColumns(10);
		txtAuteur.setBounds(562, 80, 197, 32);
		contentPane.add(txtAuteur);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblCategorie.setBounds(45, 192, 107, 32);
		contentPane.add(lblCategorie);
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		txtCat.setBounds(157, 193, 197, 32);
		contentPane.add(txtCat);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
			 	ArrayList<TypeOeuvre> types;
				TypeController ctrType = new TypeController();
					cmbType.removeAllItems();
					types=ctrType.getAll();
					for(TypeOeuvre t:types){
						cmbType.addItem(t.getNom_Fr());
					}
					
			}
		});


	}


/*
 * 
private ArticleControleur ctrArt;
private void listing(){
ctrArt=new ArticleControleur();
ArrayList<Article> allart= ctrArt.getAll();
DefaultTableModel m=(DefaultTableModel)table.getModel();
m.setNumRows(0);
for(Article art:allart)
    m.addRow(new Object[]{art.getCode(),art.getLibelle(),art.getPrix(),art.getNomCat()});
}
	 * */

}
