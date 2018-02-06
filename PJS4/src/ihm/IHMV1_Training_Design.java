package ihm;
	 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
 
/* ComboBoxDemo2.java requires no other files. */
public class IHMV1_Training_Design extends JPanel implements ActionListener {
    static JFrame frame;
    JLabel result;
    String currentPattern;
 
    public IHMV1_Training_Design() {
    	
    	//Cr�ation de la fen�tre
    	JFrame frame = new JFrame("Training");
        frame.setSize(100, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        centerWindow(frame);
    	
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS)); 
        String[] patternExamples = {
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
 
        currentPattern = patternExamples[0];
 
        //Set up the UI for selecting a pattern.
        JLabel patternLabel1 = new JLabel("Enter the pattern string or");
        JLabel patternLabel2 = new JLabel("select one from the list:");
 
        JComboBox patternList = new JComboBox(patternExamples);
        patternList.setEditable(true);
        patternList.addActionListener(this);
 
        //Create the UI for displaying result.
        JLabel resultLabel = new JLabel("Current Date/Time",
                                        JLabel.LEADING); //== LEFT
        result = new JLabel(" ");
        result.setForeground(Color.black);
        result.setBorder(BorderFactory.createCompoundBorder(
             BorderFactory.createLineBorder(Color.black),
             BorderFactory.createEmptyBorder(5,5,5,5)
        ));
 
        //Lay out everything.
        JPanel patternPanel = new JPanel();
        patternPanel.setLayout(new BoxLayout(patternPanel,
                               BoxLayout.PAGE_AXIS));
        patternPanel.add(patternLabel1);
        patternPanel.add(patternLabel2);
        patternList.setAlignmentX(Component.LEFT_ALIGNMENT);
        patternPanel.add(patternList);
 
        JPanel resultPanel = new JPanel(new GridLayout(0, 1));
        resultPanel.add(resultLabel);
        resultPanel.add(result);
 
        patternPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        resultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
 
        add(patternPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(resultPanel);
 
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        frame.pack();
        frame.setVisible(true);
    } //constructor
 
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String newSelection = (String)cb.getSelectedItem();
        currentPattern = newSelection;
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