package overlapgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Class Graph bevat de basic graph Methoden.
 * @author Karin
 */
public class Graph {
    LinkedList<LinkedList<String> > graph; 
    
    /**
     * Methode voor het aanmaken van gerichte edges.
     * 
     * @param v int Vertex index
     * @param suffix String head
     * @param prefix String tail
     */    
    public void addEdge(int v, String suffix, String prefix)
    {
        graph.get(v).add(suffix);
        graph.get(v).add(prefix);
    }

    /**
     * Methode voor het toevoegen van een Vertex
     */    
    public void addVertex(){
        graph.add( new LinkedList<>());
    }

    /**
     * Methode voor het bepalen van overlaps en deze als Edges van een Vertex in de graph te zetten.
     * 
     * @param hm HashMap met fasta-headers als keys en dnaSequenties als values.
     * @param labels ArrayList met fasta-header labels
     * @param k int k-mer
     */    
    public void overlaps(HashMap hm, ArrayList labels, int k){
       graph = new LinkedList<>();
       labels.forEach((label) -> {
           String header = label.toString();
           String suffix = hm.get(label).toString();
           
           hm.keySet().stream().filter((key) -> (!key.toString().equals(header))).filter((key) -> (hm.get(key).toString().startsWith(suffix.substring(suffix.length()-3, suffix.length())))).map((key) -> {
               addVertex();
               return key;
           }).forEachOrdered((key) -> {
               addEdge(graph.size()-1, header, key.toString() );
           });
        });
    }

    public void printGraph(){
        graph.forEach((ll) -> {
            System.out.println(ll);
        });
    }
}
