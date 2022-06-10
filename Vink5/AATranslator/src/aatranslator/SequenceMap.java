package aatranslator;

import java.util.HashMap;

/**
 *  Class bevat de datastructures en translatiemethoden van AATranslator.
 * 
 * @author Karin
 */
public class SequenceMap {
    static final String[] ONE = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"};
    static final String[] THREE = {"Ala", "Arg", "Asn", "Asp", "Cys", "Gln", "Glu", "Gly", "His", "Ile", "Leu", "Lys", "Met", "Phe", "Pro", "Ser", "Thr", "Trp", "Tyr", "Val" };
    static final String[] FULL = {"Alanine", "Arginine", "Asparagine", "Asparticacid", "Cysteine", "Glutamicacid", "Glutamine", "Glysine", "Histidine", "Isoleucine", "Leucine", "Lysine", "Methionine", "Phenylalanine", "Proline", "Serine", "Threonine", "Tryptophan", "Tyrosine", "Valine" };

    HashMap <String, String> oneToThree = new HashMap<>();
    HashMap <String, String> threeToFull = new HashMap<>();
    HashMap <String, String> fullToOne = new HashMap<>();  
	

    /**
     * 
     * @param input String user input.
     * @throws InvalidInputException voor het afhandelen van injuiste tekens of sytax.
     */
    SequenceMap(String input){
        createReferenceMaps();
   
        input = input.replaceAll("\\s", "");      
        String[] inputSeq = input.split("(?=[A-Z])");
        
        try{
            if (checkSequence(inputSeq)){
                if ( inputSeq[0].length() == 1){   
                    String output = toThreeLetter(input);
                    String output2 = toFullName(toThreeLetter(input));
                    System.out.println("De sequentie in 3-lettercode: " + output + "\nDe sequentie in volledige namen van de aminozuren: " + output2);
                }else if( inputSeq[0].length() == 3 ){
                    String output = toFullName(input);
                    String output2 = toSingleLetter(output);
                    System.out.println("De sequentie in volledige namen van de aminozuren: " + output + "\nDe sequentie in 1-lettercode: " + output2);
                }else if ( inputSeq[0].length() > 3 ){
                    String output = toSingleLetter(input);
                    String output2 = toThreeLetter(output);
                    System.out.println("De sequentie in 1-lettercode: " + output + "\nDe sequentie in 3-lettercode: " + output2);
                }
            }       
        }catch (InvalidInputException e){
            System.out.println("Invoer bevat onjuiste tekens of format:  " + e);
        }            
    }

    /**
     * Methode checkt of de ingevoerde sequenties daadwerkelijk aminozuren zijn en retourneert een boolean.
     */    
    private boolean checkSequence(String[] seq)throws InvalidInputException{
        boolean b = true;
        for(String s : seq){
            if (!oneToThree.containsKey(s) & !threeToFull.containsKey(s) & !fullToOne.containsKey(s)){
                b = false;
               throw new InvalidInputException("");
            }
        }return b;
    }

    /**
     * 
     * Methode creert referentie HashMaps voor aminozuursequenties.
     */        
    private void createReferenceMaps(){
        int i = 0;
        while ( i < ONE.length){
            oneToThree.put(ONE[i], THREE[i]);
            threeToFull.put(THREE[i], FULL[i]);
            fullToOne.put(FULL[i], ONE[i]);
            i++;
        }
    }
    
    /**
     * 
     * Methode vertaald een-letter sequentie naar 3-lettersequentie
     */    
    private String toThreeLetter(String in){ 
        String[] inputSeq = in.split("(?=[A-Z])");
        String tOutput = "";
        for ( String s : inputSeq){
            tOutput += oneToThree.get(s);
        }
        return tOutput;
}
    /**
     * 
     * Methode vertaald 3-letter sequentie naar volledige naam aminozuren.
     */    
    private String toFullName(String in){ 
        String[] inputSeq = in.split("(?=[A-Z])");
        String fOutput = "";
            for ( String s : inputSeq){
                fOutput += threeToFull.get(s);
                fOutput += " ";
            }
        return fOutput;           
}

    /**
     * 
     * Methode vertaald volledige aminozuurnamen naar 1-lettersequentie.
     */    
    private String toSingleLetter(String in){ 
        in = in.replaceAll("\\s", ""); 
        String[] inputSeq = in.split("(?=[A-Z])");

        String sOutput = "";
        for ( String s : inputSeq){
        sOutput += fullToOne.get(s);
        }
        return sOutput;        
    }
}
