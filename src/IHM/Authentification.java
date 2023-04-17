package IHM;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import control.securityController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Authentification extends JFrame {

	private int mousex,mousey;
	private JPanel contentPane;
	private securityController authenticator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 420);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousex=e.getX();
				mousey=e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX()+e.getX()-mousex,getY()+e.getY()-mousey);
			}
		});
		panel.setBackground(new Color(95, 158, 160));
		panel.setForeground(new Color(95, 158, 160));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		panel.setBounds(433, 11, 485, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClose = new JLabel("X");
		lblClose.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblClose.setForeground(new Color(240, 240, 240));
			}
		});
		lblClose.setBackground(new Color(128, 128, 128));
		lblClose.setBounds(458, 11, 17, 35);
		panel.add(lblClose);
		lblClose.setVerticalAlignment(SwingConstants.TOP);
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}

		});
		lblClose.setForeground(new Color(192, 192, 192));
		lblClose.setHorizontalAlignment(SwingConstants.CENTER);
		lblClose.setFont(new Font("Sitka Heading", Font.BOLD, 27));
		
	
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Authentification.class.getResource("/images/outside.jpg")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(0, -32, 423, 489);
		contentPane.add(lblLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(567, 220, 314, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUser = new JLabel("");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setIcon(new ImageIcon(Authentification.class.getResource("/images/user.png")));
		lblUser.setBounds(255, 0, 59, 43);
		panel_1.add(lblUser);
		
		JTextArea txtLogin = new JTextArea();
		txtLogin.setFocusCycleRoot(true);
		txtLogin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLogin.setBounds(0, 0, 263, 43);
		panel_1.add(txtLogin);
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(567, 280, 314, 43);
		contentPane.add(panel_1_1);
		
		JLabel lblUser_1 = new JLabel("");
		lblUser_1.setIcon(new ImageIcon(Authentification.class.getResource("/images/pwd.png")));
		lblUser_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser_1.setBounds(255, 0, 59, 43);
		panel_1_1.add(lblUser_1);
		
		JTextArea txtpwd = new JTextArea();
		txtpwd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtpwd.setBounds(0, 0, 263, 43);
		panel_1_1.add(txtpwd);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(Color.WHITE);
		splitPane.setBounds(391, 96, -120, 93);
		contentPane.add(splitPane);
		
		JButton cmdCon = new JButton("Connexion");
		cmdCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    authenticator=new securityController();
				Home m=null;
				if(authenticator.authenticate(txtLogin.getText().trim(),txtpwd.getText().trim())) {
				    m=new Home();
					dispose();
					m.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Login ou Mot de passe est invalide");
				}
			}
		});
		cmdCon.setFont(new Font("Times New Roman", Font.BOLD, 16));
		cmdCon.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		cmdCon.setBackground(Color.WHITE);
		cmdCon.setBounds(570, 350, 144, 31);
		contentPane.add(cmdCon);
		
		JButton CmdAnnuler = new JButton("Annuler");
		CmdAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CmdAnnuler.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CmdAnnuler.setBorder(new LineBorder(new Color(255, 250, 240), 2, true));
		CmdAnnuler.setBackground(Color.WHITE);
		CmdAnnuler.setBounds(737, 350, 144, 31);
		contentPane.add(CmdAnnuler);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(Authentification.class.getResource("/images/bulding.png")));
		lblLogo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo_1.setBounds(628, 69, 152, 120);
		contentPane.add(lblLogo_1);
		
		JLabel lblLogo_2 = new JLabel("");
		lblLogo_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo_2.setBounds(35, -32, 423, 537);
		contentPane.add(lblLogo_2);
		}
}
