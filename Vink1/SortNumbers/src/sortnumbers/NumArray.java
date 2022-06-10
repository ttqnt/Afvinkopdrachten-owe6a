/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortnumbers;

import java.util.Random;
import java.util.Scanner;

/**
 * Class met logica voor het sorteren en timen.
 * @author Karin
 */
public class NumArray {
    private int numbers[];
    
    /**
     * 
     * @param args the command line arguments
     */    
    public void createArray(){
        Random rd = new Random();
        System.out.println("Hoe veel random getallen wil je sorteren?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
       
        numbers = new int[input];
        
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = rd.nextInt();
        }
    }

    /**
     * Methode print de getallen uit een array.
     */    
    public void printArray(){
      for (int x: numbers){
        System.out.println(x);
      }        
    }
    
    /**
     * Methode sorteert getallen middels het MergeSort algoritme.
     */
    private void mergeSortArray(){
        int n = numbers.length;  
        for (int j = 1; j < n; j++) {  
            int key = numbers[j];  
            int i = j-1;  
            while ( (i > -1) && ( numbers[i] > key ) ) {  
                numbers [i+1] = numbers [i];  
                i--;  
            }  
            numbers[i+1] = key;  
        }    
    }
    
    /**
     * Methode meet hoe lang mergeSort er over doet getallen te sorteren.
     */    
    public void timeSort(){
        long startTime = System.nanoTime();
        mergeSortArray();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime); 
        
        System.out.println("mergeSort doet er " +duration/1000000 + " miliseconden over om het opgegeven aantal getallen te sorteren") ;
    }

}
