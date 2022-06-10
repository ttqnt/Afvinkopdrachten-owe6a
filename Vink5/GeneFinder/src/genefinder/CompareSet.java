package genefinder;

import java.util.Arrays;
import java.util.HashSet;


/**
 * Class bevat logica en datastrucuren voor de GeneFinder app.
 * @author Karin
 */
public class CompareSet {
    private HashSet<String> set1;
    private HashSet<String> set2;
    private HashSet<String> set3;
    private HashSet<String> intersection;

    /**
     * Constructor
     * 
     * @param input1 user input
     * @param input2 user input
     * @param input3 user input
     */
    public CompareSet(String input1, String input2, String input3) {
        set1 = new HashSet<>();
        set2= new HashSet<>();  
        set3= new HashSet<>();
        
        set1.addAll(Arrays.asList(input1.split("\n")));
        set2.addAll(Arrays.asList(input2.split("\n")));
        set3.addAll(Arrays.asList(input3.split("\n")));
    }
    
     /**
     * Methode voor het bepalen welke invoer overlapt moet worden en het retouren van deze intersectie.     * 
     * @param i int keuze dropdownmenu.
     * @return String met overlappende elementen.
     */   
    public String getIntersect(int i){
        String output = "";
        
        switch (i) {
            case 1:                
                if (set1 != null && set2 != null && set3 !=null){
                    createIntersect(set1, set2);
                    createIntersect(intersection, set3);   
                }
                break;            
            case 2:               
                if (set1 != null && set2 != null){
                    createIntersect(set1, set2); 
                }
                break;
            case 3: 
                if (set1 != null && set3 != null){
                    createIntersect(set1, set3); 
                }
                break;
            case 4:
                if (set2 != null && set3 != null){
                    createIntersect(set2, set3); 
                }
                break;                
        }
        output = intersection.stream().map((x) -> x + "\n").reduce(output, String::concat);
        return output;
    }

    /**
     * Methode van het maken van de intersectie van elementen uit twee HashSets.
     * 
     * @param a HashSet 
     * @param b HashSet
     */    
    private void createIntersect(HashSet a, HashSet b){
        intersection = new HashSet<>();
        HashSet<String> intersect = new HashSet<>(a);
        
        intersect.retainAll(b);

        intersection = intersect;
    }    
}

