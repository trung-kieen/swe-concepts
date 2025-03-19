/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.n22dccn045;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface DAOInterface <T, ID>  {
    boolean save(T t); 
    boolean delete(ID id ); 
    boolean update(T t ); 
    T findById(ID id ); 
    List<T> findAll();
}
