/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.schulbuchaktion.pojo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author marko
 */
public interface Identifiable extends Serializable{ 
    List getId();
    void setId(int d);
    String getIndexQry();
}
