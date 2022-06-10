package linkedlistvsarraylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.*;



/**
 * Class Timer bevat logica voor het bouwen van de Lists en het timen van hun performance.
 * @author Karin
 */
public class Timer {
    static ArrayList<Chromosome> chromosomeArrayList = new ArrayList<>();
    static LinkedList<Chromosome> chromosomeLinkedList = new LinkedList<>();    


    static File file = new File("~we6a_vink2\\Homo_sapiens.gene_info");
    static BufferedReader inFile;    
    int[] methodRepeats = {10, 100, 500, 1000, 5000, 10000, 50000};

    
    /**
    * Methode voor het aanmaken van een ArrayList.
    */    
    private void createArrayList(int i){
        List<String> uniqueChromosomeList = new ArrayList<>();
        int repeat = 0;
        String line;
        
        try{
            inFile = new BufferedReader(new FileReader(file));
            inFile.readLine();
            
            while ((line = inFile.readLine()) != null && repeat < i){
                String[] columns = line.split("\t");
                
                if (!uniqueChromosomeList.contains(columns[6])){
                    uniqueChromosomeList.add(columns[6]);
                    chromosomeArrayList.add(new Chromosome(columns[6]));
                    repeat++;
                }                 
                chromosomeArrayList.stream().filter((x) -> (x.getChromosome().equals(columns[6]))).forEachOrdered((x) -> {
                    x.addGene(Integer.parseInt(columns[1]), columns[2], columns[7]);
                });
                
        }
            inFile.close();
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("IO exception");
        }  
    }

    /**
    * Methode voor het aanmaken van een LinkedList.
    */        
    private void createLinkedList(int i){
        List<String> uniqueChromosomeList = new ArrayList<>();
        int repeat = 0;
        
        String line;
        try{
            inFile = new BufferedReader(new FileReader(file));
            inFile.readLine();
            
            while ((line = inFile.readLine()) != null && repeat < i){
                String[] columns = line.split("\t");
                
                if (!uniqueChromosomeList.contains(columns[6])){
                    uniqueChromosomeList.add(columns[6]);
                    chromosomeLinkedList.add(new Chromosome(columns[6]));
                    repeat++;
                }                 
                chromosomeLinkedList.stream().filter((x) -> (x.getChromosome().equals(columns[6]))).forEachOrdered((x) -> {
                    x.addGene(Integer.parseInt(columns[1]), columns[2], columns[7]);
                });                 
            }
            inFile.close();                  
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        } catch (IOException ex) {
            System.out.println("IO exception");
        }        
    }   

    /**
    * Methode voor het timen van de aanmaak van een ArrayList.
    */
    public void timerArrayList(){
        
        for ( int r : methodRepeats){
            long startTime = System.nanoTime();
            createArrayList(r); 
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Het creeren van een arrayList van Chromosome objecten met een geneste arrayList van " + r + " Gene objecten duurt " + duration/1000000 + " milliseconden.");             
        }
        System.out.println("\n");
        
        for ( int r : methodRepeats){
            getGeneArrayList(r);           
        }      

    }
    
    /**
    * Methode voor het timen van de aanmaak van een LinkedList.
    */   
       public void timerLinkedList(){
        
        for ( int r : methodRepeats){
            long startTime = System.nanoTime();
            createArrayList(r); 
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println("Het creeren van een geneste LinkedList van  " + r + " Chromosome en Gene objecten duurt " + duration/1000000 + " milliseconden.");             
        }
        System.out.println("\n");
        
        for ( int r : methodRepeats){
            getGeneLinkedList(r);           
        }      
    } 

    /**
    * Methode voor het timen van het n x herhalen van ophalen van een gen op basis van index uit een ArrayList.
    * @param n int.
    */   
    private void getGeneArrayList(int n){
        Random rand = new Random();
        
        createArrayList(n);
        int r1 = rand.nextInt(chromosomeArrayList.size()); 
        int r2 = rand.nextInt(chromosomeArrayList.get(r1).getGeneListsize());  
        
        long startTime = System.nanoTime();          
        chromosomeArrayList.get(r1).getGene(r2);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
   
        System.out.println("Het ophalen van een gen op basis van index uit een geneste Arraylist met " + n + " objecten duurt " + duration + " nanoseconden.");
    } 
    
    /**
    * Methode voor het timen van het n x herhalen van ophalen van een gen op basis van index van een LinkedList.
    * @param n int.
    */   
    private void getGeneLinkedList(int n){
        Random rand = new Random();

        createLinkedList(n);
        int r1 = rand.nextInt(chromosomeLinkedList.size()); 
        int r2 = rand.nextInt(chromosomeLinkedList.get(r1).getGeneListsize());  
        
        long startTime = System.nanoTime();          
        chromosomeLinkedList.get(r1).getGene(r2);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        
        System.out.println("Het ophalen van een gen op basis van index uit een geneste LinkedList met " + n + " objecten duurt " + duration + " nanoseconden.");
        
    } 
    
}

