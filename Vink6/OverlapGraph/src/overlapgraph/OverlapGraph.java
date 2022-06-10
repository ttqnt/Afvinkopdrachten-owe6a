package overlapgraph;

/**
 *Applicatie voor het maken van een DNAsequentie-overlap Graph
 * @author Karin
 */
public class OverlapGraph {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadFasta fasta = new ReadFasta("~ SampleDataset.fasta");
        Graph overlapGraph = new Graph();

        overlapGraph.overlaps(fasta.getGraphData(), fasta.getLabels(), 3);
        overlapGraph.printGraph();
    }
}
