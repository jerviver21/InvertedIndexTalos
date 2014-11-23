package com.talosrecruit.invertedindextalos.serachengine;

import com.talosrecruit.invertedindextalos.exceptions.TStringException;
import com.talosrecruit.invertedindextalos.model.TIndex;
import com.talosrecruit.invertedindextalos.model.TString;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jerviver21
 */
public class InvertedIndexSearchEngine extends SearchEngine{
    
    @Override
    protected void addString(String data)throws TStringException{
        
        
        if(tstrings.get(data) != null){
            throw new TStringException("The string '"+data+"' is already contained in the database, please try other string");
        }
        
        long index = tstrings.size() + 1;
        TString tstring = new TString();
        tstring.setTstring(data);
        tstring.setIndex(index);
        
        tstrings.put(data, tstring);
    }
    
    @Override
    public void indexString(String tstring)throws TStringException{
        addString(tstring);
        
        String[] words = tstring.split("[,;\\.]*\\s+[,;\\.]*");
        
        for(int position = 0 ; position < words.length; position++ ){
            String word = words[position];
            List<TIndex> indexs = indexMap.get(word);
            if(indexs == null){
                indexs = new ArrayList();
            }
            
            TIndex tindex = new TIndex();
            tindex.setPosition(position);
            tindex.setTstring(tstrings.get(tstring));
            
            indexs.add(tindex);
            
            indexMap.put(word, indexs);
            
        }
    }
    
    @Override
    public void loadStrings(String[] dataarray)throws TStringException{
        for(String data:dataarray){
            indexString(data);
        }
    }
    
    
    public String[] get(String data){
        String[] hits = null;
        
        List<TIndex> indexes = indexMap.get(data);
        
        if(indexes != null){
            hits = new String[indexes.size()];
            for (int i = 0; i < indexes.size(); i++) {
                TIndex ti = indexes.get(i);
                hits[i] = ti.getTstring().getTstring();
            }
        }else{
            hits = new String[]{};
        }
            
        
        return hits;
    }
    
    
}
