package ru.kpfu.itis.kashshapov.dao.impl;

import ru.kpfu.itis.kashshapov.dao.Dao;
import ru.kpfu.itis.kashshapov.dto.CourseCommentDto;
import ru.kpfu.itis.kashshapov.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseCommentDao implements Dao<CourseCommentDto> {
    //language=sql
    private static final String GET_ALL = "select * from course_comments";
    //language=sql
    private static final String GET_BY_ID = "select * from course_comments where id=?";
    //language=sql
    private static final String ADD = "insert into course_comments (description, time_created, positive, user_id, course_id, university_id) values (?, ?, ?, ?, ?, ?)";
    //language=sql
    private static final String DELETE = "delete from course_comments where id = ?";
    @Override
    public CourseCommentDto getById(Long id) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            CourseCommentDto course = null;
            if (resultSet != null) {
                resultSet.next();
                    course = new CourseCommentDto(
                            resultSet.getLong("id"),
                            resultSet.getString("description"),
                            resultSet.getString("time_created"),
                            resultSet.getBoolean("positive"),
                            resultSet.getLong("user_id"),
                            resultSet.getLong("course_id"),
                            resultSet.getLong("university_id")
                    );
            }
            return course;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CourseCommentDto> getAll() {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<CourseCommentDto> courses = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    courses.add(new CourseCommentDto(
                            resultSet.getLong("id"),
                            resultSet.getString("description"),
                            resultSet.getString("time_created"),
                            resultSet.getBoolean("positive"),
                            resultSet.getLong("user_id"),
                            resultSet.getLong("course_id"),
                            resultSet.getLong("university_id")
                    ));
                }
            }
            return courses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(CourseCommentDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, model.getDescription());
            statement.setString(2, model.getTimeCreated());
            statement.setBoolean(3, model.getPositive());
            statement.setLong(4, model.getUserId());
            statement.setLong(5, model.getCourseId());
            statement.setLong(6, model.getUniversityId());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(CourseCommentDto model) {
        return false;
    }

    @Override
    public void delete(CourseCommentDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
