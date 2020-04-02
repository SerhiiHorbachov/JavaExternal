package ua.com.computers.dao.abstracts;

import ua.com.computers.exceptions.DaoException;
import ua.com.computers.models.Entity;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO<T extends Entity> {

    protected Connection connection;

    public AbstractDAO() {
    }

    public abstract List<T> findAll() throws DaoException;

    public abstract T findEntityById(int id) throws DaoException;

    public abstract boolean delete(int id) throws DaoException;

    public abstract boolean delete(T entity);

    public abstract int create(T entity) throws DaoException;

    public abstract T update(T entity);

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}

