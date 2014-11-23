package com.talosrecruit.invertedindextalos;

import com.talosrecruit.invertedindextalos.exceptions.TStringException;
import com.talosrecruit.invertedindextalos.searchengine.InvertedIndexSearchEngine;
import com.talosrecruit.invertedindextalos.searchengine.SearchEngine;
import java.util.Arrays;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;





/**
 * Clase principal en la que se realiza el llamado al InvertedIndexSearchEngine.
 * @author Jerson Viveros
 */
public class App{

    public App(){
        
    }
    
    public static void main( String[] args ){

        String[] data = new String[]{   "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", 
                                        "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir", 
                                        "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell", 
                                        "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith", 
                                        "Another book with music related content"  };
        
        SearchEngine se = new InvertedIndexSearchEngine();
        
        try {
            se.loadStrings(data);
        } catch (TStringException e) {
           e.printStackTrace();
        }
        
        
        String[] result = se.get("music");
        
        System.out.println(result.length);
   
        
        System.out.println(Arrays.toString(result)); 

    }
}
