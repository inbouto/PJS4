package ihm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
 
public class IHMV1_Design extends JPanel implements ActionListener {
	
	private JTextField textField;
    private JTextArea textAreaUser;
    private JTextArea textAreaIA;
    private final static String newline = "\n";
 
    public IHMV1_Design() {
        super(new GridBagLayout());      
        
        
        this.ajouterTexteUser();
        this.ajouterTexteIA();
        this.ajouterZoneDeTexte();
    }
    
    public void ajouterZoneDeTexte(){
    	//Code de la zone de saisie
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
        
        add(panelTextField, GridBagConstraints.PAGE_END);  
    }
    
    public void ajouterTexteUser(){ 
    	//Code permettant d'afficher le texte entr�
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
        
        add(panelTextAreaUser, GridBagConstraints.LINE_START);
    }
    
    public void ajouterTexteIA(){
    	//Code permettant d'afficher le texte de l'IA
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
        
        add(panelTextAreaIA, GridBagConstraints.LINE_END);    
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
     private static void creationFenetre() {
    	 //Cr�ation de la fen�tre
         JFrame frame = new JFrame("L'IAPP");
         frame.setSize(300, 150);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setResizable(false);
         centerWindow(frame);
         
         frame.getContentPane().add(new IHMV1_Design());
         
         frame.pack();
         frame.setVisible(true);
     }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	creationFenetre();
            }
        });
    }
}
