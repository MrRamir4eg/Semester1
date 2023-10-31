package ru.kpfu.itis.kashshapov.dao.impl;

import ru.kpfu.itis.kashshapov.dao.Dao;
import ru.kpfu.itis.kashshapov.dto.DiscussionDto;
import ru.kpfu.itis.kashshapov.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiscussionDaoImpl implements Dao<DiscussionDto> {
    //language=sql
    private static final String GET_ALL = "select * from discussions";
    //language=sql
    private static final String GET_BY_ID = "select * from discussions where id = ?";
    //language=sql
    private static final String ADD = "insert into discussions (title, content, time_created, user_id) VALUES (?,?,?,?)";

    @Override
    public DiscussionDto getById(Long id) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            DiscussionDto discussion = null;
            if (resultSet != null) {
                resultSet.next();
                discussion = new DiscussionDto(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getString("time_created"),
                        resultSet.getLong("user_id")
                );
            }
            return discussion;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DiscussionDto> getAll() {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = statement.executeQuery();
            List<DiscussionDto> discussions = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    DiscussionDto discussion = new DiscussionDto(
                            resultSet.getLong("id"),
                            resultSet.getString("title"),
                            resultSet.getString("content"),
                            resultSet.getString("time_created"),
                            resultSet.getLong("user_id")
                    );
                    discussions.add(discussion);
                }
            }
            return discussions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(DiscussionDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, model.getTitle());
            statement.setString(2, model.getDescription());
            statement.setString(3, model.getTimeCreated());
            statement.setLong(4, model.getUser_id());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(DiscussionDto model) {
        return false;
    }

    @Override
    public void delete(DiscussionDto model) {

    }
}
