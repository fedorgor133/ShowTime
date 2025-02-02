package ub.edu.resources.dao;

import java.util.Optional;

public interface DAOEntity<T> extends DAO<T> {
    /**
     * @param id unique identifier of the class T.
     * @return an optional with Data of T (for instance a customer)
     * if a customer with unique identifier <code>id</code>
     * exists, empty optional otherwise.
     * @throws Exception if any error occurs.
     */
    Optional<T> getById(String[] id) throws Exception;

    /**
     * @param t is the data to be updated.
     * @return true if data exists and is successfully updated, false otherwise.
     * @throws Exception if any error occurs.
     */
    boolean update(T t, String[] params) throws Exception;
}
