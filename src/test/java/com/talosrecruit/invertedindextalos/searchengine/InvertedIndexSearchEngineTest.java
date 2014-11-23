/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.talosrecruit.invertedindextalos.searchengine;

import com.talosrecruit.invertedindextalos.exceptions.TStringException;
import java.util.Arrays;
import junit.framework.TestCase;

/**
 *
 * @author jerviver21
 */
public class InvertedIndexSearchEngineTest extends TestCase {
    
    public InvertedIndexSearchEngineTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

 


    /**
     * Test of get method, of class InvertedIndexSearchEngine.
     */
    public void testGet() {
        System.out.println("get");
        String[] data = new String[]{   "A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", 
                                        "Fatima Bhutto on Malala Yousafzai's fearless and still-controversial memoir", 
                                        "Grisham's sequel to A Time to Kill is a solid courtroom drama about racial prejudice marred by a flawless white hero, writes John O'Connell", 
                                        "This strange repackaging of bits and pieces does the Man Booker winner no favours, says Sam Leith", 
                                        "Another book with music related content"  };
        InvertedIndexSearchEngine instance = new InvertedIndexSearchEngine();
        try {
            instance.loadStrings(data);
        } catch (TStringException e) {
           e.printStackTrace();
        }

        String[] expResult = new String[]{"A brilliant, festive study of JS Bach uses literature and painting to illuminate his 'dance-impregnated' music, writes Peter Conrad", "Another book with music related content"};
        String[] result = instance.get("music");
        
        assertEquals(Arrays.toString(expResult), Arrays.toString(result));
        
    }
    
}
