package IHM;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;

public class testjframe extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testjframe frame = new testjframe();
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
	public testjframe() {
		getContentPane().setBackground(new Color(144, 238, 144));
		setBounds(100, 100, 450, 300);

	}

}
