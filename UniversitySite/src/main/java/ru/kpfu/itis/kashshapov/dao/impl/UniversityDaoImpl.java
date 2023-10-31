package ru.kpfu.itis.kashshapov.dao.impl;

import ru.kpfu.itis.kashshapov.dao.Dao;
import ru.kpfu.itis.kashshapov.dto.UniversityDto;
import ru.kpfu.itis.kashshapov.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UniversityDaoImpl implements Dao<UniversityDto> {
    //language=sql
    private static final String GET_ALL = "select * from universities";
    //language=sql
    private static final String GET_BY_ID = "select * from universities where id = ?";
    //language=sql
    private static final String GET_BY_NAME = "select * from universities where name = ?";
    @Override
    public UniversityDto getById(Long id) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            UniversityDto university = null;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
                university = new UniversityDto(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("gerb_img"),
                        resultSet.getString("add_img")
                );
            }
            return university;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UniversityDto> getAll() {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            List<UniversityDto> universities = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    universities.add(new UniversityDto(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getString("gerb_img"),
                            resultSet.getString("add_img")
                    ));
                }
            }
            return universities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(UniversityDto model) {
        return false;
    }

    @Override
    public boolean update(UniversityDto model) {
        return false;
    }

    @Override
    public void delete(UniversityDto model) {

    }

    public UniversityDto getByName(String name) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_NAME);
            statement.setString(1, name);
            UniversityDto university = null;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
                university = new UniversityDto(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("gerb_img"),
                        resultSet.getString("add_img")
                );
            }
            return university;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
