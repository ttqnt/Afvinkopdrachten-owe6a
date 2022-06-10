package aatranslator;

import java.util.Scanner;

/**
 * Applicatie voor het omzetten van aminozuusequenties naar verschillende coderingen.
 * @author Karin
 */
public class AATranslator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    
        System.out.print("Voer aminozuursequentie in, dit programma splitst de sequentie op hoofdletters: ");  
        String inputSequence = in.nextLine();
       
        SequenceMap transformSeq = new SequenceMap(inputSequence);
    } 
}
