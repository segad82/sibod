/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;

/**
 *
 * @author kevin
 */
public interface IDao<T> {
    ArrayList<T> Select(T data, Object[] parameters, Option option);
    T Execute(T data, Action action);
}
