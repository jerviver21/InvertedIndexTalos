package com.talosrecruit.invertedindextalos.model;

/**
 *
 * @author jerviver21
 */
public class TString {
    private Long index;
    private String tstring;

    /**
     * @return the index
     */
    public Long getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(Long index) {
        this.index = index;
    }

    /**
     * @return the tstring
     */
    public String getTstring() {
        return tstring;
    }

    /**
     * @param tstring the tstring to set
     */
    public void setTstring(String tstring) {
        this.tstring = tstring;
    }
    
    
    @Override
    public int hashCode(){
        return tstring.hashCode();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof TString){
            TString tstr = (TString)obj;
            return tstring.equals(tstr.getTstring());
        }
        return false;
    }
    
}
