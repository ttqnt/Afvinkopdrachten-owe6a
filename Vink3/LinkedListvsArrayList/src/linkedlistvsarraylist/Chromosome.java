
package linkedlistvsarraylist;


import java.util.*;

/**
 * Class voor Chromosome objecten die in de lijsten worden opgeslagen.
 * @author karin
 */
public class Chromosome {
    private String chromosome;
    private List<Gene> geneList = new ArrayList<>();

    /**
     * Constructor
     * 
     * @param c String chromosome
     * @param i int geneID
     * @param s String symbol
     * @param m String mapLocation
    */ 
    public Chromosome(String c, int i, String s, String m){
        setChromosome(c);
        addGene(i, s, m);
    }      

    /**
     * Constructor
     * @param c String chromosome
    */     
    public Chromosome(String c){
        setChromosome(c);
    }
 
    /**
     * @param n String chromosome
    */     
    private void setChromosome(String n){
        chromosome = n;
    }
    
    /**
     * @return String chromosome
    */  
    public String getChromosome(){
        return chromosome;
    }
 
    /**
     * Methode voor het toevoegen van Gene Objecten aan lijst.
     * 
     * @param iD int geneID
     * @param sym String symbol
     * @param mapl String mapLocation
    */ 
    public final void addGene(int iD, String sym, String mapl){
        geneList.add(new Gene(iD, sym, mapl));
    }

    /**
     * @return int lengte van geneList 
    */     
    public int getGeneListsize(){
        return geneList.size();
    }

    /**
     * @param t int index
     * @return Gene object
    */     
    public Gene getGene(int t){
        return geneList.get(t);
    }

    /**
     * @return String informatie Gen object.
    */     
    public String printGeneInfo(){
        String s = "";
        s = geneList.stream().map((g) -> getChromosome()+ " " + g.getGeneID() + " " + g.getSymbol() + " " + g.getMapLoc() +" \n").reduce(s, String::concat);
        return s;
    }
    
}

