/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Indizes;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author marko
 */
public interface BaseDAO<T> {   
    List<T> find(String selectStatement);
    List<T> findAll();
    T findByID(Indizes idx);
    void delete(T obj);
    PreparedStatement getInsertStatement(T obj);
    void insert(T obj);
    void update(T obj);
}
