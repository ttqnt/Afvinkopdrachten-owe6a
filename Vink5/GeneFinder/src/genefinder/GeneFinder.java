package genefinder;

import javax.swing.JFrame;

/**
 * Applicatie voor het bepalen van overlap in 2 of 3 lijsten met genen.
 * @author Karin
 */
public class GeneFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            	GUI frame = new GUI();
		frame.setSize(420,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
