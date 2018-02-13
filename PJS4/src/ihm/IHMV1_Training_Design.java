package ihm;
	 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


public class IHMV1_Training_Design extends JPanel implements ActionListener {
    JLabel result;
    String currentClasse;
 
    public IHMV1_Training_Design() {
    	super(new GridBagLayout());
    	
    	//Cr�ation de la fen�tre
    	JFrame frame = new JFrame("Training");
        frame.setSize(100, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        centerWindow(frame);
    	
        //frame.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
        String[] classes = {
                 "Nourriture",
                 "Jeux",
                 "Animaux",
                 "Films",
                 "Sports",
                 "Etudes",
                 "Travail",
                 "Bizarre",
                 "Monuments"
        };
 
        currentClasse = classes[0];
 
        //Set up the UI for selecting a pattern.
        JLabel label1 = new JLabel("S�lectionnez la classe correspondante");
        JLabel label2 = new JLabel("ou ajoutez en une � la liste");
 
        JComboBox listeClasses = new JComboBox(classes);
        listeClasses.setEditable(true);
        listeClasses.addActionListener(this);
 
//        //Create the UI for displaying result.
//        JLabel resultLabel = new JLabel("Current Date/Time", JLabel.LEADING); //== LEFT
//        result = new JLabel(" ");
//        result.setForeground(Color.black);
//        result.setBorder(BorderFactory.createCompoundBorder(
//             BorderFactory.createLineBorder(Color.black),
//             BorderFactory.createEmptyBorder(5,5,5,5)
//        ));
// 
        //Lay out everything.
        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel, BoxLayout.PAGE_AXIS));
        patternPanel.add(label1);
        patternPanel.add(label2);
        listeClasses.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        listeClasses.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        patternPanel.add(listeClasses);
 
//        JPanel resultPanel = new JPanel(new GridLayout(0, 1));
//        resultPanel.add(resultLabel);
//        resultPanel.add(result);
 
        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
//        resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        patternPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 
        frame.add(patternPanel, BorderLayout.PAGE_START);
//        frame.add(Box.createRigidArea(new Dimension(0, 10)));
//        frame.add(resultPanel);
         
        frame.pack();
        frame.setVisible(true);
    }
    
    public void creerComboBoxClasses(){
    	setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
        String[] classes = {
                 "Nourriture",
                 "Jeux",
                 "Animaux",
                 "Films",
                 "Sports",
                 "Etudes",
                 "Travail",
                 "Bizarre",
                 "Monument"
        };
 
        currentClasse = classes[0];
 
        //Set up the UI for selecting a pattern.
        JLabel label1 = new JLabel("S�lectionnez la classe correspondante");
        JLabel label2 = new JLabel("ou ajoutez en une � la liste");
 
        JComboBox listeClasses = new JComboBox(classes);
        listeClasses.setEditable(true);
        listeClasses.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String newSelection = (String)cb.getSelectedItem();
        currentClasse = newSelection;
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
     * event-dispatching thread.
     */
//    private static void createAndShowGUI() {
// 
//        //Create and set up the content pane.
//        JComponent newContentPane = new IHMV1_Training_Design();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
// 
//    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new IHMV1_Training_Design();
            }
        });
    }
}