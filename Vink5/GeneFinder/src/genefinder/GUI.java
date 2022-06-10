/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genefinder;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Class bevat GUI elementen van applicatie.
 * @author Karin
 */
public class GUI extends JFrame implements ActionListener {
    private JButton calculateButton;
    private JTextArea invoer1, invoer2, invoer3, output;
    private JScrollPane scroll1, scroll2, scroll3, scroll4;
    private JComboBox dropDownMenu;
    private String[] dropDownOpties = { "overeenkomst 1 & 2 & 3", "overeenkomst 1 & 2", "overeenkomst 1 & 3", "overeenkomst 2 & 3"};
    private CompareSet geneData;
    
    public GUI(){
        super("Genefinder");
        setLayout(new FlowLayout());
        
        invoer1 = new JTextArea();
        invoer1.setPreferredSize(new Dimension(100, 180));
        invoer1.setLineWrap(true);
        invoer1.setRows(8);
        add(invoer1);
	scroll1 = new JScrollPane ( invoer1 );
	scroll1.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll1.setViewportView(invoer1);      
	add (scroll1);            

        invoer2 = new JTextArea();
        invoer2.setPreferredSize(new Dimension(100, 180));
        invoer2.setLineWrap(true);
        invoer2.setRows(8);        
        add(invoer2);
	scroll2 = new JScrollPane ( invoer2 );
	scroll2.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	add (scroll2);       

        invoer3 = new JTextArea();
        invoer3.setPreferredSize(new Dimension(100, 180));
        invoer2.setLineWrap(true);
        invoer3.setRows(8);
        add(invoer3);
	scroll3 = new JScrollPane ( invoer3 );
	scroll3.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	scroll3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	add (scroll3);               
      
        dropDownMenu = new JComboBox(dropDownOpties);
        dropDownMenu.setSelectedIndex(0);
        add(dropDownMenu);
        dropDownMenu.addActionListener(this);        

        calculateButton = new JButton("Calculate");
	add(calculateButton);
        calculateButton.addActionListener(this); 
        
        output = new JTextArea();
        output.setPreferredSize(new Dimension(340, 300));
        output.setEditable(false);
        output.setLineWrap(true);
        output.setRows(8);
        add(output); 
	scroll4 = new JScrollPane ( output );
	scroll4.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
	scroll4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add (scroll4);           
    }
    
    @Override
     public void actionPerformed(ActionEvent e) {
        geneData = new CompareSet(invoer1.getText(), invoer2.getText(), invoer3.getText());
               
        if(e.getSource() == calculateButton){
            if (dropDownOpties[0].equals(dropDownMenu.getSelectedItem())){
                output.setText(geneData.getIntersect(1));                
            } else if (dropDownOpties[1].equals(dropDownMenu.getSelectedItem())){
                output.setText(geneData.getIntersect(2));
            } else if (dropDownOpties[2].equals(dropDownMenu.getSelectedItem())){
                output.setText(geneData.getIntersect(3));                
            } else if (dropDownOpties[3].equals(dropDownMenu.getSelectedItem())){
                output.setText(geneData.getIntersect(4));                
            }
        } else if(e.getSource() == dropDownMenu){
            if (dropDownMenu.getSelectedItem().equals(dropDownOpties[0])){
                output.setText(geneData.getIntersect(1));
            } else if (dropDownMenu.getSelectedItem().equals(dropDownOpties[1])){
              output.setText(geneData.getIntersect(2));  
            }else if (dropDownMenu.getSelectedItem().equals(dropDownOpties[2])){
                output.setText(geneData.getIntersect(3));
            }else if (dropDownMenu.getSelectedItem().equals(dropDownOpties[3])){
                output.setText(geneData.getIntersect(4)); 
            }
        } 
    }
     
}
