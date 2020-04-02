package ua.com.computers.services;

import ua.com.computers.dao.impl.PartDaoImpl;
import ua.com.computers.dao.impl.TypeDAOImpl;
import ua.com.computers.database.EntityTransaction;
import ua.com.computers.exceptions.DaoException;
import ua.com.computers.models.Part;

import java.util.List;

public class PartService {
    
    public List<Part> getAll() {

        PartDaoImpl partDao = new PartDaoImpl();
        TypeDAOImpl typeDAO = new TypeDAOImpl();
        EntityTransaction transaction = new EntityTransaction();

        List<Part> parts = null;
        transaction.begin(partDao, typeDAO);

        try {
            parts = partDao.findAll();

            for (Part part : parts) {
                if (part.getType_id() > 0) {
                    Part.Type type = typeDAO.findEntityById(part.getType_id());
                    part.setType(type);
                }
            }

            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();

        } finally {
            transaction.end();
        }

        return parts;
    }

    public Part findById(int id) {
        Part part = null;

        PartDaoImpl partDao = new PartDaoImpl();
        TypeDAOImpl typeDAO = new TypeDAOImpl();
        EntityTransaction transaction = new EntityTransaction();

        transaction.begin(partDao, typeDAO);

        try {
            part = partDao.findEntityById(id);

            if (part.getType_id() > 0) {
                Part.Type type = typeDAO.findEntityById(part.getType_id());
                part.setType(type);
            }

            transaction.commit();
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();

        } finally {
            transaction.end();
        }

        return part;
    }

    public boolean create(Part part) {
        boolean isCreated = false;

        PartDaoImpl partDao = new PartDaoImpl();
        TypeDAOImpl typeDAO = new TypeDAOImpl();

        EntityTransaction transaction = new EntityTransaction();
        transaction.begin(partDao, typeDAO);

        try {
            int typeId = typeDAO.create(part.getType());
            part.setType_id(typeId);
            partDao.create(part);
            transaction.commit();
            isCreated = true;
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.end();
        }

        return isCreated;
    }

    public boolean delete(int id) {
        boolean isDeleted = false;

        PartDaoImpl partDao = new PartDaoImpl();
        TypeDAOImpl typeDAO = new TypeDAOImpl();

        EntityTransaction transaction = new EntityTransaction();
        transaction.begin(partDao, typeDAO);

        try {
            Part part = findById(id);

            partDao.delete(id);
            typeDAO.delete(part.getType_id());

            transaction.commit();
            isDeleted = true;
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            transaction.end();
        }

        return isDeleted;
    }


}
