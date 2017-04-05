/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;
import at.htlpinkafeld.schulbuchaktion.pojo.Indizes;

/**
 *
 * @author marko
 */
interface BuecherDAO extends BaseDAO<Buch>{ 
    void setBuchStatus(Indizes idx,boolean val);

}
