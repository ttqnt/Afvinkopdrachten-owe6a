package geneobjectensorteren;

/**
 * Class voor Gene Objects die gesorteerd moeten worden.
 * @author karin
 */
public class Gene implements Comparable {
    private int geneID;
    private String symbol;
    private String cMapLocation;

    /**
     * Constructor voor Gene objecten.
     * @param id int geneID.
     * @param sym String symbol.
     * @param mapl String mapLocation.
     */    
    public Gene(int id, String sym, String mapl){
        setGeneID(id);
        setSymbol(sym);
        setMapLoc(mapl);
    }

    /**
     * Set GeneID
     * @param id int geneID.
     */        
    private void setGeneID(int i){
        geneID = i;
    }
    
    /**
     * Returns geneID
     * @return int geneID.
     */        
    public int getGeneID(){
        return geneID;
    }

    /**
     * Set Symbol
     */            
    private void setSymbol(String s){
        symbol = s;
    }

    /**
     * Returns Symbol
     * @return String symbol.
     */            
    public String getSymbol(){
        return symbol;
    }

    /**
     * Set mapLocation
     */            
    private void setMapLoc(String m){
        cMapLocation = m;
    }

    /**
     * Returns mapLocation
     * @return String cMaplocation.
     */            
    public String getMapLoc(){
        return cMapLocation;
    }
    
     /**
     * overridden compareTO() methode.
     */               
    @Override
    public int compareTo(Object o){
        int value = 0;
        
        if(this.getMapLoc().charAt(0) != '-' && (((Gene)o).getMapLoc().charAt(0)) != '-'){
            if (!Character.isDigit(this.getMapLoc().charAt(1)) && Character.isDigit(this.getMapLoc().charAt(0)) ){
                value += -100;
            } 
            if (!Character.isDigit(((Gene)o).getMapLoc().charAt(1)) && Character.isDigit(((Gene)o).getMapLoc().charAt(0)) ){
                value += 100;
            }
        } else if(this.getMapLoc().charAt(0) != '-' ){
            value += -100;
        } else if ((((Gene)o).getMapLoc().charAt(0)) != '-'){
            value += 100;
        }

        value += this.getMapLoc().compareTo(((Gene)o).getMapLoc());
        return value;
    }
}
