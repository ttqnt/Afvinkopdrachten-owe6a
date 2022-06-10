
package linkedlistvsarraylist;

/**
 * Class voor Gene objecten die per chromosoom worden opgeslagen worden in geneste lijsten.
 * @author karin
 */
public class Gene implements Comparable {
    private int geneID;
    private String symbol;
    private String cMapLocation;
    
    /**
    * Constructor
     * @param id int geneID
     * @param sym String symbol
     * @param mapl String mapLocation
    */   
    public Gene(int id, String sym, String mapl){
        setGeneID(id);
        setSymbol(sym);
        setMapLoc(mapl);
    }
 
    /**
     * @param i int geneID
    */   
    private void setGeneID(int i){
        geneID = i;
    }
    
    /**
     * @return geneID
    */   
    public int getGeneID(){
        return geneID;
    }

    /**
     * @param s String symbol
    */       
    private void setSymbol(String s){
        symbol = s;
    }

    /**
     * @return String symbol
    */       
    public String getSymbol(){
        return symbol;
    }
    
    /**
     * @param m String mapLocation
    */     
    private void setMapLoc(String m){
        cMapLocation = m;
    }

    /**
     * @return String mapLocation
    */     
    public String getMapLoc(){
        return cMapLocation;
    }
        
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
