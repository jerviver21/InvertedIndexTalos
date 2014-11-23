package com.talosrecruit.invertedindextalos.serachengine;

import com.talosrecruit.invertedindextalos.exceptions.TStringException;
import com.talosrecruit.invertedindextalos.model.TIndex;
import com.talosrecruit.invertedindextalos.model.TString;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jerviver21
 */
public abstract class SearchEngine {
    Map<String, TString> tstrings;
    Map<String, List<TIndex>>  indexMap;
    
    public SearchEngine(){
        tstrings = new HashMap();
        indexMap = new HashMap();
    }
    
    
    protected abstract void addString(String data)throws TStringException;
    
    
    public abstract void indexString(String data)throws TStringException;
    
    
    public abstract void loadStrings(String[] data)throws TStringException;
    
    
    public abstract String[] get(String data);
    
}
