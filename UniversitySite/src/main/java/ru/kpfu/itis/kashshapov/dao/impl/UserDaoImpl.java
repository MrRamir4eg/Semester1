package ru.kpfu.itis.kashshapov.dao.impl;

import ru.kpfu.itis.kashshapov.dao.Dao;
import ru.kpfu.itis.kashshapov.dto.UserDto;
import ru.kpfu.itis.kashshapov.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements Dao<UserDto> {
    //language=sql
    private final static String SQL_GET_USER_BY_ID = "select * from users where id = ?";
    //language=sql
    private final static String SQL_GET_USER_BY_EMAIL_AND_PASSWORD = "select * from users where email = ? and password = ?";
    //language=sql
    private final static String SQL_ADD_USER = "insert into users (email, password, first_name, last_name, date_of_birth, gender, snils, role, image_url) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //language=sql
    private final static String UPDATE_USER = "update users set first_name = ?, last_name = ?, image_url = ? where id = ?";
    //language=sql
    private final static String DELETE_USER = "delete from users where id=?";

    @Override
    public UserDto getById(Long id) {
        try(Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            UserDto user = null;
            if (resultSet != null){
                resultSet.next();
                user = new UserDto(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("snils"),
                        resultSet.getString("role"),
                        resultSet.getString("image_url")
                );
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UserDto getByEmailAndPassword(String email, String password) {
        try(Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(SQL_GET_USER_BY_EMAIL_AND_PASSWORD);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            UserDto user = null;
            if (resultSet != null){
                resultSet.next();
                user = new UserDto(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getString("date_of_birth"),
                        resultSet.getString("snils"),
                        resultSet.getString("role"),
                        resultSet.getString("image_url")
                );
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    @Override
    public boolean add(UserDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER);
            statement.setString(1, model.getEmail());
            statement.setString(2, model.getPassword());
            statement.setString(3, model.getFirstName());
            statement.setString(4, model.getLastName());
            statement.setString(5, model.getDateOfBirth());
            statement.setString(6, model.getGender());
            if (model.getSnils() != null) {
                statement.setString(7, model.getSnils());
            } else {
                statement.setNull(7, Types.VARCHAR);
            }
            statement.setString(8, model.getRole());
            if (model.getImageUrl() != null) {
                statement.setString(9, model.getImageUrl());
            } else {
                statement.setNull(9, Types.VARCHAR);
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(UserDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, model.getFirstName());
            statement.setString(2, model.getLastName());
            if (model.getImageUrl() != null){
                statement.setString(3, model.getImageUrl());
            } else {
                statement.setNull(3, Types.VARCHAR);
            }
            statement.setLong(4, model.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(UserDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.setLong(1, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
