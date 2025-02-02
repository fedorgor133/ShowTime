package ub.edu.resources.dao;

import java.util.List;

public interface DAO<T> {
    /**
     * @return all the customers as a List.
     * @throws Exception if any error occurs.
     */
    List<T> getAll() throws Exception;

    /**
     * @param t the data to be added.
     * @return true if the data is successfully added, false if the data already exists.
     * @throws Exception if any error occurs.
     */
    boolean add(T t) throws Exception;


    /**
     * @param t is the data  to be deleted.
     * @return true if data exists and is successfully deleted, false otherwise.
     * @throws Exception if any error occurs.
     */
    boolean delete(T t) throws Exception;
}
