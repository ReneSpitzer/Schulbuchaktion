/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author marko
 */
public class Indizes {

    private Map<String, Object> indizes;
    
    public Indizes(){
        indizes=new HashMap<>();
    }
    
    public void addIndex(String description, Object val){
        indizes.put(description, val);
    }
    
    public Map getIndizesMap(){
        return new HashMap(indizes);
    }
    
    public void replaceValue(String key, Object value)
    {
        if(indizes.containsKey(key)){
            indizes.replace(key, value);
        }
    }
}
