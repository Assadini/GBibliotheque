package IHM;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import control.OeuvreControl;
import control.TypeController;
import objets_metiers.Oeuvre;
import objets_metiers.TypeOeuvre;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateOeuvre extends JFrame {


	private JPanel contentPane;
	private JTextField txtTitre;
	private JTextField txtAuteur;
	private JTextField txtCat;
	private JTextField txtId;
  private JComboBox cmbType;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateOeuvre frame = new UpdateOeuvre(o);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public UpdateOeuvre(Oeuvre o) {

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
		
		JButton cmdCon = new JButton("Modfier");
		cmdCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TypeController tc=new TypeController();
				OeuvreControl oc=new OeuvreControl();
				Oeuvre o=new Oeuvre(Integer.parseInt(txtId.getText()),txtTitre.getText(),txtAuteur.getText(),txtCat.getText(),0,0,0,tc.getByNom(cmbType.getSelectedItem().toString()));
			   if(oc.modify(o))
				   JOptionPane.showMessageDialog(null,"Modifié Avec Succées");
			   else
				   JOptionPane.showMessageDialog(null,"Echec");
			 new GestionOeuvresExemplaires().listing();
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
		lbltitre.setBounds(45, 107, 90, 32);
		contentPane.add(lbltitre);
		
	     cmbType = new JComboBox();
		cmbType.setBounds(562, 193, 197, 32);
		contentPane.add(cmbType);
		
		txtTitre = new JTextField();
		txtTitre.setBounds(157, 108, 197, 32);
		contentPane.add(txtTitre);
		txtTitre.setColumns(10);
		
		JLabel lbltitre_1 = new JLabel("Type");
		lbltitre_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbltitre_1.setBounds(450, 189, 90, 32);
		contentPane.add(lbltitre_1);
		
		JLabel lblAuteur = new JLabel("Auteur");
		lblAuteur.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblAuteur.setBounds(450, 107, 90, 32);
		contentPane.add(lblAuteur);
		
		txtAuteur = new JTextField();
		txtAuteur.setColumns(10);
		txtAuteur.setBounds(562, 108, 197, 32);
		contentPane.add(txtAuteur);
		
		JLabel lblCategorie = new JLabel("Categorie");
		lblCategorie.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblCategorie.setBounds(45, 192, 107, 32);
		contentPane.add(lblCategorie);
		
		txtCat = new JTextField();
		txtCat.setColumns(10);
		txtCat.setBounds(157, 193, 197, 32);
		contentPane.add(txtCat);
		
		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblId.setBounds(45, 63, 90, 32);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		txtId.setBounds(157, 64, 197, 32);
		contentPane.add(txtId);
		
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
					
					txtId.setText(o.getId()+"");
					txtTitre.setText(o.getTitre());
					txtAuteur.setText(o.getAuteur());
					txtCat.setText(o.getCategorie());
					
			}
		});
		
	}
}
