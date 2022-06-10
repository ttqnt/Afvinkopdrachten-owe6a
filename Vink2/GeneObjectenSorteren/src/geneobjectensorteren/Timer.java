package geneobjectensorteren;


import java.util.Collections;
import java.util.Random;
import java.util.*;


/**
 * Class bevat timerlogica.
 * @author Karin
 */
public class Timer {
    int[] methodRepeats = {10, 100, 500, 1000, 10000, 61700};
    
    
    public void timeMethod(ArrayList<Gene> geneList, int i){

    switch (i) {
            case 1:  i = 1;
                for (int r: methodRepeats ){
                    repeatSort(geneList, r);
                }
                break;
            case 2:  i = 2;
                for (int r: methodRepeats ){
                    repeatInsert(geneList, r);
                }
                break;
            case 3:  i = 3;
                for (int r: methodRepeats ){
                    repeatGetGeneByGeneID(geneList, r);
                }
                break;
            case 4:  i = 4;
                for (int r: methodRepeats ){
                    repeatGetGeneFromIndex(geneList, r);
                }
                break;
        }
    }
      /** 
     * Methode voor het herhalen en timen van het sorteren van de array op chromosome map location.
     * @param ArrayList<Gene>
     * @param int
     */      
    private void repeatSort(ArrayList<Gene> geneList, int n){
        int repeat = 0;
        List<Gene> sortList = new ArrayList<>();
        while (repeat < n){            
            sortList.add(geneList.get(repeat));
            repeat++;
        }

        long startTime = System.nanoTime();
        Collections.sort(sortList);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        
        if (n != 10){
        System.out.println("Het sorteren van een lijst met " + n + " Gene objecten duurt " + duration/1000000 + " milliseconden.");            
        }
    }
    /** 
     * Methode voor het herhalen en timen van het inserten van een gen in het midden van de array.
     * @param ArrayList<Gene>
     * @param int
     */    
    private void repeatInsert(ArrayList<Gene> geneList, int n){
        int repeat = 0;
        List<Gene> insertMList = new ArrayList<>();

        while (repeat < n){            
            insertMList.add(geneList.get(repeat));
            repeat++;
        }
        
        long startTime = System.nanoTime();
        insertMList.add(insertMList.size()/2, new Gene(99099, "JHKLAB3", "26p9.13"));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        
        if (n != 10){        
        System.out.println("Het inserten in het midden van een lijst met " + n + " Gene objecten duurt " + duration + " nanoseconden.");   
        }
    } 

    /** 
     * Methode voor herhalen en timen van ophalen gen op basis van geneID.
     * @param ArrayList<Gene>
     * @param int
     */      

    private void repeatGetGeneByGeneID(ArrayList<Gene> geneList, int n){
        int repeat = 0;
        List<Gene> insertGeneIDList = new ArrayList<>();

        while (repeat < n){            
            insertGeneIDList.add(geneList.get(repeat));
            repeat++;
        }

        int geneID = insertGeneIDList.get(insertGeneIDList.size()/2).getGeneID();

        long startTime = System.nanoTime();        
        insertGeneIDList.stream().filter((g) -> (g.getGeneID() == geneID)).forEachOrdered((g) -> {
            g.getGeneID();
        });
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        if (n != 10){        
        System.out.println("Het ophalen van een gen op basis van geneID uit een lijst met " + n + " Gene objecten duurt " + duration + " nanoseconden.");
        }
    }
    
    /** 
     * Methode voor het het herhalen en timen van ophalen van een gen op basis van index.
     * @param ArrayList<Gene>
     * @param int
     */    

    private void repeatGetGeneFromIndex(ArrayList<Gene> geneList, int n){
        int repeat = 0;
        Random rand = new Random();
        List<Gene> insertGeneFromIndex = new ArrayList<>();

        while (repeat < n){            
            insertGeneFromIndex.add(geneList.get(repeat));
            repeat++;
        }
        int r = rand.nextInt(insertGeneFromIndex.size()); 
        long startTime = System.nanoTime();          
        insertGeneFromIndex.get(r);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        
        if (n != 10){
        System.out.println("Het ophalen van een gen op basis van index uit een lijst met " + n + " Gene objecten duurt " + duration + " nanoseconden.");
        }
    }    
}

