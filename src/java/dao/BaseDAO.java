/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlpinkafeld.dao;

import at.htlpinkafeld.schulbuchaktion.pojo.Identifiable;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author marko
 */
public interface BaseDAO<T> {   
    public void insert(T t);

    public T read(List id);

    public void update(T t);

    public void delete(T t);

    public List<T> list();
}
