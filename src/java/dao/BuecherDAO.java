/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Buch;

/**
 *
 * @author marko
 */
interface BuecherDAO extends BaseDAO<Buch>{ 
    void setBuchStatus(Buch idx, boolean val);
}
