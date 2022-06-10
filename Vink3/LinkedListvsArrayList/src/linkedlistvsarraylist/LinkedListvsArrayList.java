package linkedlistvsarraylist;

/**
 * Applicatie test de Big O van ArrayList vs LinkedList
 * @author karin
 */
public class LinkedListvsArrayList {
    Timer bigOData = new Timer();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer bigOData = new Timer();
        
        bigOData.timerArrayList();
        System.out.println("\n");
        bigOData.timerLinkedList();

        System.out.println("\nDe Big O voor het creeeren van de Arraylist is O(n^2)\nDe Big O voor het creeeren van de Linkedlist is ook O(n^2)\nIn Theorie zou de LinkedList sneller moeten zijn, add() is O(1) voor LinkedList en O(n) voor Arraylist, maar dit is hier niet terug te zien, daarnaast moet bij aan aanmaken van beide lists een if loop in een while loop worden doorlopen, waarmee de big O op O(n^2) komt, en voor de ArrayList theoretisch gezien O(n^3) zou moeten zijn. Sowieso is het bepalen van de big O van code op basis van tijd gemeten hier niet heel betrouwbaar omdat de big O asymptotisch gedrag beschrijft.");
        System.out.println("\nBij het ophalen van een gen op basis van index is wel een duidelijk verschil te zien, wellicht omdat hier ook echt alleen de get() methode van de lists getimed wordt; Voor de ArrayList is dit O(1) en voor LinkedList O (n)");
    } 
}
