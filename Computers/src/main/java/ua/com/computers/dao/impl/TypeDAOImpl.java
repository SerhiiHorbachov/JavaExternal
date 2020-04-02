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

public class TypeDAOImpl extends AbstractDAO<Part.Type> {
    private static final String SELECT_ALL_TYPES_QUERY = "SELECT * FROM types";
    private static final String SELECT_TYPE_BY_ID_QUERY =
            "SELECT id, periphery, energy_consumption, units, cooler_included, product_group, port FROM types WHERE id = (?)";
    private static final String CREATE_TYPE_QUERY =
            "INSERT INTO types (periphery, energy_consumption, units, cooler_included, product_group, port) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_TYPE_BY_ID_QUERY = "DELETE FROM types WHERE id = (?)";

    @Override
    public List<Part.Type> findAll() throws DaoException {
        List<Part.Type> types = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_TYPES_QUERY);

            while (resultSet.next()) {
                Part.Type type = new Part.Type();

                type.setId(resultSet.getInt("id"));
                type.setPeriphery(resultSet.getBoolean("periphery"));
                type.setEnergyConsumption(resultSet.getInt("energy_consumption"));
                type.setUnits(resultSet.getString("units"));
                type.setCoolerIncluded(resultSet.getBoolean("cooler_included"));
                type.setGroup(resultSet.getString("product_group"));
                type.setPort(resultSet.getString("port"));

                types.add(type);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return types;
    }

    @Override
    public Part.Type findEntityById(int id) throws DaoException {
        Part.Type type = new Part.Type();

        try (PreparedStatement statement = connection.prepareStatement(SELECT_TYPE_BY_ID_QUERY)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                type.setId(Integer.parseInt(rs.getString("id")));
                type.setPeriphery(Boolean.parseBoolean(rs.getString("periphery")));
                type.setEnergyConsumption(Integer.parseInt(rs.getString("energy_consumption")));
                type.setUnits(rs.getString("units"));
                type.setCoolerIncluded(Boolean.parseBoolean(rs.getString("cooler_included")));
                type.setGroup(rs.getString("product_group"));
                type.setPort(rs.getString("port"));
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return type;
    }

    @Override
    public boolean delete(int id) throws DaoException {
        int affectedRows = 0;
        try (PreparedStatement statement = connection.prepareStatement(DELETE_TYPE_BY_ID_QUERY)) {
            statement.setInt(1, id);
            affectedRows = statement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return affectedRows > 0;
    }

    @Override
    public boolean delete(Part.Type entity) {
        return false;
    }

    @Override
    public int create(Part.Type type) throws DaoException {

        int generatedKey = 0;
        try (PreparedStatement statement = connection.prepareStatement(CREATE_TYPE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setBoolean(1, type.isPeriphery());
            statement.setInt(2, type.getEnergyConsumption());
            statement.setString(3, type.getUnits());
            statement.setBoolean(4, type.isCoolerIncluded());
            statement.setString(5, type.getGroup());
            statement.setString(6, type.getPort());

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
    public Part.Type update(Part.Type entity) {
        return null;
    }
}
