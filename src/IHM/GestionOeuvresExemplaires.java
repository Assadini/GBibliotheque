package IHM;

import Utility.BibalExceptions;
import Utility.ModelTableau;
import static Utility.Utility.showMessageSucces;
import control.OeuvreControl;
import control.TypeController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.table.*;
import objets_metiers.Livre;
import objets_metiers.Magazine;
import objets_metiers.Oeuvre;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Aymen Souelmi
 */
public class GestionOeuvresExemplaires extends JInternalFrame implements MouseListener {

    private JButton RecherchBouton;
    private JFormattedTextField RecherchField;
    private JLabel RecherchParLabel;
    private JButton ajouterBouton;
    private JButton exemplaireButton;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton modifierBouton;
    private JPanel panListeOeuvre;
    private JPanel panRecherch;
    private JButton supprimerButton;
    public static JTable table;
    private OeuvreControl ctrOeuvre;
    public GestionOeuvresExemplaires() {

        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setResizable(false);
        table.addMouseListener(this);
        table.addMouseListener(this);
        getContentPane().setLayout(null);
        table.setRowHeight(30);
        getContentPane().add(jPanel1);
        jPanel1.setLayout(null);
        jPanel1.add(jLabel1);
        jPanel1.add(panel);
        jPanel1.add(panListeOeuvre);
        jPanel1.add(panRecherch);
      
       // setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bibliotheque_icone.png")));
        setVisible(true);
        setBorder(null);
        listing();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel1.setBounds(0, 0, 698, 534);
        panRecherch = new JPanel();
        panRecherch.setBounds(10, 77, 675, 99);
        RecherchParLabel = new JLabel();
        RecherchParLabel.setForeground(new Color(255, 255, 255));
        panListeOeuvre = new JPanel();
        panListeOeuvre.setBounds(0, 194, 685, 231);
        jScrollPane1 = new JScrollPane();
     
        table = new JTable();
        jLabel1 = new JLabel();
        jLabel1.setBounds(108, 23, 547, 43);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des oeuvres et des Exemplaires");
        setResizable(false);
        setBorder(null);
        BasicInternalFrameUI bui=(BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        
        

        jPanel1.setBackground(new Color(0, 128, 128));
        jPanel1.setName("Gestion personnel");
        jPanel1.setPreferredSize(new Dimension(1162, 608));
        jPanel1.setRequestFocusEnabled(false);

        panRecherch.setBackground(new Color(0, 128, 128));
        panRecherch.setBorder(BorderFactory.createTitledBorder("Rechercher"));

        RecherchParLabel.setText("Rechercher par  ");
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Par Titre");
        
        JRadioButton rdbtnParAuteur = new JRadioButton("Par Auteur");
        
        panel_1 = new JPanel();

        GroupLayout panRecherchLayout = new GroupLayout(panRecherch);
        panRecherchLayout.setHorizontalGroup(
        	panRecherchLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panRecherchLayout.createSequentialGroup()
        			.addGap(118)
        			.addComponent(RecherchParLabel)
        			.addGap(18)
        			.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        			.addGap(27)
        			.addComponent(rdbtnParAuteur, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        		.addGroup(panRecherchLayout.createSequentialGroup()
        			.addGap(159)
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(172))
        );
        panRecherchLayout.setVerticalGroup(
        	panRecherchLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panRecherchLayout.createSequentialGroup()
        			.addGroup(panRecherchLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(RecherchParLabel)
        				.addGroup(panRecherchLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(rdbtnNewRadioButton)
        					.addComponent(rdbtnParAuteur)))
        			.addGap(18)
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        			.addGap(20))
        );
        panel_1.setLayout(null);
        RecherchBouton = new JButton();
        RecherchBouton.setBounds(285, 0, 47, 26);
        panel_1.add(RecherchBouton);
        RecherchBouton.setBackground(new Color(255, 255, 255));
        RecherchBouton.setIcon(new ImageIcon(GestionOeuvresExemplaires.class.getResource("/images/search.png")));
        RecherchBouton.setPreferredSize(new Dimension(47, 26));
        RecherchField = new JFormattedTextField();
        RecherchField.setBounds(0, 0, 292, 26);
        panel_1.add(RecherchField);
        RecherchField.setAlignmentY(Component.TOP_ALIGNMENT);
        RecherchField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
                RecherchField.setHorizontalAlignment(JTextField.CENTER);
                RecherchField.setPreferredSize(new Dimension(130, 26));
        RecherchBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               // RecherchBoutonActionPerformed(evt);
            }
        });
        panRecherch.setLayout(panRecherchLayout);

        panListeOeuvre.setBackground(new Color(0, 128, 128));
        panListeOeuvre.setBorder(BorderFactory.createTitledBorder("Liste des Oeuvres"));

        jScrollPane1.getViewport().setBackground(Color.white);
        jScrollPane1.setBackground(new Color(255, 255, 255));

       table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Titre", "Auteur", "Catégorie", "Type", "Exemplaires", "Réservations"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        GroupLayout panListeOeuvreLayout = new GroupLayout(panListeOeuvre);
        panListeOeuvreLayout.setHorizontalGroup(
        	panListeOeuvreLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, panListeOeuvreLayout.createSequentialGroup()
        			.addContainerGap(51, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
        			.addGap(49))
        );
        panListeOeuvreLayout.setVerticalGroup(
        	panListeOeuvreLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(panListeOeuvreLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(15, Short.MAX_VALUE))
        );
        panListeOeuvre.setLayout(panListeOeuvreLayout);

        jLabel1.setFont(new Font("Times New Roman", 1, 36));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Gestion des Oeuvres et Exemplaires");
        
        panel = new JPanel();
        panel.setBounds(10, 431, 641, 43);
        panel.setLayout(null);
        ajouterBouton = new JButton();
        ajouterBouton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        ajouterBouton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        ajouterBouton.setBounds(51, 11, 93, 29);
        panel.add(ajouterBouton);
        
                ajouterBouton.setFont(new Font("Times New Roman", 1, 18));
                ajouterBouton.setText("Ajouter");
                modifierBouton = new JButton();
                modifierBouton.setBounds(176, 11, 101, 29);
                panel.add(modifierBouton);
                
                        modifierBouton.setFont(new Font("Times New Roman", 1, 18));
                        modifierBouton.setText("Modifier");
                        modifierBouton.setEnabled(false);
                        supprimerButton = new JButton();
                        supprimerButton.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		OeuvreControl oc=new OeuvreControl();
                				Oeuvre o=getOeuvreInfos();
                						if(oc.delete(o)) {
                				   JOptionPane.showMessageDialog(null,"Supprimé Avec Succées");
                						listing();
                						}else
                				   JOptionPane.showMessageDialog(null,"Echec");
                			 new GestionOeuvresExemplaires().listing();
                        	}
                        });
                        supprimerButton.setBounds(337, 11, 117, 29);
                        panel.add(supprimerButton);
                        
                                supprimerButton.setFont(new Font("Times New Roman", 1, 18));
                                supprimerButton.setText("Supprimer");
                                supprimerButton.setEnabled(false);
                                exemplaireButton = new JButton();
                                exemplaireButton.setBounds(493, 11, 121, 29);
                                panel.add(exemplaireButton);
                                
                                        exemplaireButton.setFont(new Font("Times New Roman", 1, 18));
                                        exemplaireButton.setText("Exemplaire");
                                        exemplaireButton.setEnabled(false);
                                        exemplaireButton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                                exemplaireButtonActionPerformed(evt);
                                            }
                                        });
                        modifierBouton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                modifierBoutonActionPerformed(evt);
                            }
                        });
                ajouterBouton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        ajouterBoutonActionPerformed(evt);
                    }
                });

        setSize(new Dimension(698, 561));
    }
  

    private void ajouterBoutonActionPerformed(ActionEvent evt) {
        AddOeuvre ajoutOeuvre = new AddOeuvre();
        ajoutOeuvre.setLocationRelativeTo(null);
        ajoutOeuvre.setVisible(true);
    }

    private void modifierBoutonActionPerformed(ActionEvent evt) {
       
    	Oeuvre oeuvre = getOeuvreInfos();
        if (null != oeuvre) {
            UpdateOeuvre modificationOeuvre = new UpdateOeuvre(oeuvre);
            modificationOeuvre.setLocationRelativeTo(null);
            modificationOeuvre.setVisible(true);
        }
    }


    private void exemplaireButtonActionPerformed(ActionEvent evt) {
        Oeuvre oeuvre = getOeuvreInfos();
        if (null != oeuvre) {
            GestionExemplaire exemplaires = new GestionExemplaire(getOeuvreInfos());
            exemplaires.setLocationRelativeTo(null);
            exemplaires.setVisible(true);
        }
    }

    private Oeuvre getOeuvreInfos() {
        Oeuvre oeuvre = null;
        if (table.getSelectedRow() != -1) {
            int id = parseInt(dataLigneSelected[0].toString());
            String titre = dataLigneSelected[1].toString();
            String auteur = dataLigneSelected[2].toString();
            String categorie = dataLigneSelected[3].toString();
            String typeOeuvre = dataLigneSelected[4].toString();
            int nbExemplaire = parseInt(dataLigneSelected[5].toString());
            int nbResa = parseInt(dataLigneSelected[6].toString());
                
            oeuvre = new Oeuvre(id, titre, auteur, categorie, nbResa,nbExemplaire,0,null);
           
            oeuvre.getExamplairesOeuvre().setSize(nbExemplaire);
        }
        return oeuvre;

    }

   

    @Override
    public void mouseClicked(MouseEvent e) {
    	
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int row = table.getSelectedRow();
        int nbreCol = table.getColumnCount();

        dataLigneSelected = new Object[nbreCol];
        if (row >= 0) {
            for (int i = 0; i < nbreCol; i++) {
                dataLigneSelected[i] = table.getModel().getValueAt(row, i);
            }
            modifierBouton.setEnabled(true);
            supprimerButton.setEnabled(true);
            exemplaireButton.setEnabled(true);
        } else {
            modifierBouton.setEnabled(false);
            supprimerButton.setEnabled(false);
            exemplaireButton.setEnabled(true);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
     
    public void listing(){
    	try {
    		ctrOeuvre=new OeuvreControl();
        	ArrayList<Oeuvre> allOv= ctrOeuvre.getAll();
        	DefaultTableModel m=(DefaultTableModel)table.getModel();
        	m.setNumRows(0);
        	for(Oeuvre o:allOv)
        	    m.addRow(new Object[] {o.getId(),o.getTitre(),o.getAuteur(),o.getCategorie(),o.getType().getNom_Fr(),o.getNbExemplaire(),o.getNbResa()});	
    	} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    	
    	}
    private Object dataLigneSelected[];
    private JPanel panel;
    private JPanel panel_1;
}
