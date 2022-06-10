/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortnumbers;

/**
 * Applicatie voor het sorteren van getallen.
 * @author Karin
 */
public class SortNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumArray num = new NumArray();
        num.createArray();
        num.timeSort();
    }

}
