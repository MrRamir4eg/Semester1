package ru.kpfu.itis.kashshapov.dao.impl;

import ru.kpfu.itis.kashshapov.dao.Dao;
import ru.kpfu.itis.kashshapov.dto.CourseDto;
import ru.kpfu.itis.kashshapov.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements Dao<CourseDto> {
    //language=sql
    private static final String GET_ALL = "select * from courses order by code_name";
    //language=sql
    private static final String GET_BY_ID = "select * from courses where id=?";
    //language=sql
    private static final String GET_BY_CODE_NAME = "select * from courses where code_name = ?";
    @Override
    public CourseDto getById(Long id) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            CourseDto course = null;
            if (resultSet != null) {
                resultSet.next();
                    course = new CourseDto(
                            resultSet.getLong("id"),
                            resultSet.getString("code_name"),
                            resultSet.getString("name"),
                            resultSet.getString("description")
                    );

            }
            return course;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CourseDto> getAll() {
        try (Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<CourseDto> courses = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    courses.add(new CourseDto(
                            resultSet.getLong("id"),
                            resultSet.getString("code_name"),
                            resultSet.getString("name"),
                            resultSet.getString("description")
                    ));
                }
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(CourseDto model) {
        return false;
    }

    @Override
    public boolean update(CourseDto model) {
        return false;
    }

    @Override
    public void delete(CourseDto model) {

    }

    public CourseDto getByCodeName(String codeName) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(GET_BY_CODE_NAME);
            statement.setString(1, codeName);
            ResultSet resultSet = statement.executeQuery();
            CourseDto course = null;
            if (resultSet != null) {
                resultSet.next();
                course = new CourseDto(
                        resultSet.getLong("id"),
                        resultSet.getString("code_name"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );

            }
            return course;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
