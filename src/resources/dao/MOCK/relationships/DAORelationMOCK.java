package resources.dao.MOCK.relationships;

import resources.dao.DAO;

import java.util.ArrayList;
import java.util.List;

public class DAORelationMOCK<T> implements DAO<T> {
    protected List<T> relations = new ArrayList<>();

    @Override
    public List<T> getAll() throws Exception {
        return relations;
    }

    @Override
    public boolean add(T t) throws Exception {
        if (relations.contains(t)){
            return false;
        }
        relations.add(t);
        return true;
    }

    @Override
    public boolean delete(T t) throws Exception {
        if (relations.contains(t)){
            relations.remove(t);
            return true;
        }
        return false;
    }
}
