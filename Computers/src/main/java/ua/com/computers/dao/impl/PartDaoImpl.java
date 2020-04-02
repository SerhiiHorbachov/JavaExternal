package ua.com.computers.dao.impl;

import ua.com.computers.dao.abstracts.AbstractDAO;
import ua.com.computers.exceptions.DaoException;
import ua.com.computers.models.Part;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PartDaoImpl extends AbstractDAO<Part> {
    private static final String SELECT_ALL_PARTS_QUERY = "SELECT * FROM parts";
    private static final String SELECT_PART_BY_ID_QUERY =
            "SELECT id, name, origin, price, currency, critical, type_id FROM parts WHERE id = (?)";
    private static final String CREATE_PART_QUERY =
            "INSERT INTO parts (name, origin, price, currency, critical, type_id) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_PART_BY_ID_QUERY = "DELETE FROM parts WHERE id = (?)";


    @Override
    public List<Part> findAll() throws DaoException {
        List<Part> parts = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_PARTS_QUERY);

            while (resultSet.next()) {
                Part part = new Part();

                part.setId(resultSet.getInt("id"));
                part.setName(resultSet.getString("name"));
                part.setOrigin(resultSet.getString("origin"));
                part.setPrice(resultSet.getInt("price"));
                part.setCurrency(resultSet.getString("currency"));
                part.setCritical(resultSet.getBoolean("critical"));
                part.setType_id(resultSet.getInt("type_id"));

                parts.add(part);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return parts;
    }

    @Override
    public Part findEntityById(int id) throws DaoException {
        Part part = new Part();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_PART_BY_ID_QUERY)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                part.setId(Integer.parseInt(rs.getString("id")));
                part.setName(rs.getString("name"));
                part.setOrigin(rs.getString("origin"));
                part.setPrice(Integer.parseInt(rs.getString("price")));
                part.setCurrency(rs.getString("currency"));
                part.setCritical(Boolean.parseBoolean(rs.getString("critical")));
                part.setType_id(Integer.parseInt(rs.getString("type_id")));
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return part;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        int affectedRows = 0;
        
        try (PreparedStatement statement = connection.prepareStatement(DELETE_PART_BY_ID_QUERY)) {
            statement.setInt(1, id);
            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return affectedRows > 0;
    }

    @Override
    public boolean delete(Part entity) {
        return false;
    }

    @Override
    public int create(Part part) throws DaoException {
        int generatedKey = 0;
        try (PreparedStatement statement = connection.prepareStatement(CREATE_PART_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, part.getName());
            statement.setString(2, part.getOrigin());
            statement.setInt(3, part.getPrice());
            statement.setString(4, part.getCurrency());
            statement.setBoolean(5, part.getCritical());
            statement.setInt(6, part.getType_id());

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return generatedKey;
    }

    @Override
    public Part update(Part entity) {
        return null;
    }
}
