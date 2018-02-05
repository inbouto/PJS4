package ihm;

//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextArea;
//import java.awt.BorderLayout;
//import javax.swing.JTextPane;
//import javax.swing.JSplitPane;
//
//public class IHMV1_Design {
//
//	private JFrame frame;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IHMV1_Design window = new IHMV1_Design();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
//	public IHMV1_Design() {
//		initialize();
//	}
//
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 633, 486);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		JTextArea TextEntre = new JTextArea();
//		TextEntre.setText("ENTREZ VOTRE TEXTE DANS CETTE FENETRE");
//		frame.getContentPane().add(TextEntre);
//		
//		JTextArea TextGenere = new JTextArea();
//		TextGenere.setText("LA REPONSE DE L'IA S'AFFICHE ICI");
//		frame.getContentPane().add(TextGenere);
//	}
//
//}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
 
public class IHMV1_Design extends JPanel implements ActionListener {
    protected JTextField textField;
    protected JTextArea textAreaUser;
    protected JTextArea textAreaIA;
    private final static String newline = "\n";
 
    public IHMV1_Design() {
        super(new GridBagLayout());
        
        //Create and set up the window.
        JFrame frame = new JFrame("L'IAPP");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        centerWindow(frame);
 
        //Add contents to the window.
        //frame.getContentPane().add(new IHMV1_Design());
        
        //code de la zone de saisie
        JPanel panelTextField = new JPanel();
        
        TitledBorder borderTextField = new TitledBorder("Tapez ici votre texte");
        borderTextField.setTitleJustification(TitledBorder.CENTER);
        borderTextField.setTitlePosition(TitledBorder.TOP);
        
        panelTextField.setBorder(borderTextField);
         
        textField = new JTextField(82);
        textField.addActionListener(this);
 
        GridBagConstraints zoneDeSaisie = new GridBagConstraints();
        
        zoneDeSaisie.gridwidth = GridBagConstraints.REMAINDER; 
        zoneDeSaisie.fill = GridBagConstraints.HORIZONTAL;
        
        panelTextField.add(textField, zoneDeSaisie);
        
        frame.add(panelTextField, BorderLayout.PAGE_END);
        
        
        //code permettant d'afficher le texte entr�
        JPanel panelTextAreaUser = new JPanel();
        
        TitledBorder borderTextAreaUser = new TitledBorder("Votre texte");
        borderTextAreaUser.setTitleJustification(TitledBorder.CENTER);
        borderTextAreaUser.setTitlePosition(TitledBorder.TOP);
        
        panelTextAreaUser.setBorder(borderTextAreaUser);
        
        textAreaUser = new JTextArea(15, 40);
        textAreaUser.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaUser);
        
        GridBagConstraints zoneTexteUser = new GridBagConstraints();
        
        zoneTexteUser.fill = GridBagConstraints.WEST;
        zoneTexteUser.weightx = 1.0;
        zoneTexteUser.weighty = 1.0;
        
        panelTextAreaUser.add(scrollPane, zoneTexteUser);
        
        frame.add(panelTextAreaUser, BorderLayout.LINE_START);
        
        
        //code permettant d'afficher le texte entr�
        JPanel panelTextAreaIA = new JPanel();
        
        TitledBorder borderTextAreaIA = new TitledBorder("R�ponse de l'IA");
        borderTextAreaIA.setTitleJustification(TitledBorder.CENTER);
        borderTextAreaIA.setTitlePosition(TitledBorder.TOP);
        
        panelTextAreaIA.setBorder(borderTextAreaIA);
        
        textAreaIA = new JTextArea(15, 40);
        textAreaIA.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(textAreaIA);

        GridBagConstraints zoneTexteIA = new GridBagConstraints();
        
        zoneTexteIA.fill = GridBagConstraints.EAST;
        zoneTexteIA.weightx = 1.0;
        zoneTexteIA.weighty = 1.0;
        
        panelTextAreaIA.add(scrollPane2, zoneTexteIA);
        
        frame.add(panelTextAreaIA, BorderLayout.LINE_END);
        
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent evt) {
        String text = textField.getText();
        textAreaUser.append(text + newline);
        textField.selectAll();
 
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textAreaUser.setCaretPosition(textAreaUser.getDocument().getLength());
       
        textAreaIA.append(text + newline);
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textAreaIA.setCaretPosition(textAreaUser.getDocument().getLength());
    }
    
    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 3.5);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 3.5);
        frame.setLocation(x, y);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
//    private static void createAndShowGUI() {
//        //Create and set up the window.
//    	JFrame.setDefaultLookAndFeelDecorated(true);
//        JFrame frame = new JFrame("Le Fermier Ukrainien");
//        frame.setSize(300, 150);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// 
//        //Add contents to the window.
//        frame.getContentPane().add(new IHMV1_Design());
// 
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//    }
 
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new IHMV1_Design();
            }
        });
    }
}
