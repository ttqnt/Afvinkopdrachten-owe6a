package geneobjectensorteren;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Applicatie voor het sorteren van Gene objecten.
 * @author karin
 */
public class GeneObjectenSorteren {
    static ArrayList<Gene> geneList = new ArrayList<>();
    static File file = new File("~owe6a_vink2\\Homo_sapiens.gene_info");
    static BufferedReader inFile;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Timer bigOData = new Timer();
    
    try{
        inFile = new BufferedReader(new FileReader(file));
        inFile.readLine();
        String line = null;
            
        while ((line = inFile.readLine()) != null){
            String[] columns = line.split("\t");
            geneList.add(new Gene(Integer.parseInt(columns[1]), columns[2], columns[7]));                
        }
        inFile.close();                  
                    
    }catch(FileNotFoundException e){
        System.out.println("file not found");
    } catch (IOException ex) {
        Logger.getLogger(GeneObjectenSorteren.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    bigOData.timeMethod(geneList, 1);
    System.out.println("Big O = O (n^2) \n");
    bigOData.timeMethod(geneList, 2);
    System.out.println("Big O = O (log n) \n");
    bigOData.timeMethod(geneList, 3);
    System.out.println("Big O = O (n) \n");
    bigOData.timeMethod(geneList, 4);  
    System.out.println("Big O = O (1) \n");

    }
}
