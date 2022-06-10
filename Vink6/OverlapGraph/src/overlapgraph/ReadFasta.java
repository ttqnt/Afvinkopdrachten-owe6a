package overlapgraph;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 * Uitlezen van fastafile.
 * 
 * @author Karin
 */
public final class ReadFasta {
    private static BufferedReader inFile;
    ArrayList<String> labels;
    HashMap <String, String> graphData = new HashMap<>();
    
    /**
     * Constructor.
     * Leest fastafile uit en geeft data door aan een ArrayList met header-labels en de setGraphData() functie.
     * @param path absolute path of fasta file.
     */
    public ReadFasta(String path) {
        labels = new ArrayList<>();
        ArrayList<String> dnaSeq = new ArrayList<>();      
        String line;
        
        try{
            inFile = new BufferedReader(new FileReader(path));           

            while ((line = inFile.readLine()) != null){
                if(line.charAt(0) == '>'){
                   labels.add(line);
                }else {
                      dnaSeq.add(line);
                }
            }            
            inFile.close(); 
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Bestand niet gevonden");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kan bestand niet lezen");
        }
        setGraphData(labels, dnaSeq);      
    }
    
    /**
     * 
     * parsed data in een hashmap met headerlabels als key en dnasequentie als value.
     * @param l ArrayList met header-labels.
     * @param s Arraylist met dna sequenties.
     */
    public void setGraphData(ArrayList<String> l, ArrayList<String> s){
        int i = 0;
        while ( i < l.size()){
            graphData.put(l.get(i), s.get(i));
            i++;
        }
    }
    
    /**
     * 
     * @return returns hashmap graphData.
     */
    public HashMap getGraphData(){
        return graphData;
    }    

    /**
     * 
     * @return returns Arraylist met fastaheader-labels.
     */
    public ArrayList getLabels(){
        return labels;
    }     
}
