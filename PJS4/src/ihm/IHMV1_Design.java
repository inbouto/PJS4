package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JSplitPane;

public class IHMV1_Design {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMV1_Design window = new IHMV1_Design();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IHMV1_Design() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 633, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea txtrDufygtuskgkjgjdfsgkjgkgsjgfs = new JTextArea();
		txtrDufygtuskgkjgjdfsgkjgkgsjgfs.setText("dufygtuskgkjgjdfsgkjgkgsjgfs");
		frame.getContentPane().add(txtrDufygtuskgkjgjdfsgkjgkgsjgfs, BorderLayout.WEST);
		
		JTextPane txtpnIsjhmshmhjsmhjhmhsh = new JTextPane();
		txtpnIsjhmshmhjsmhjhmhsh.setText("isjhmshmhjsmhjhmhsh");
		frame.getContentPane().add(txtpnIsjhmshmhjsmhjhmhsh, BorderLayout.EAST);
	}

}
