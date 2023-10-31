package ru.kpfu.itis.kashshapov.dao.impl;

import ru.kpfu.itis.kashshapov.dao.Dao;
import ru.kpfu.itis.kashshapov.dto.DiscussionCommentDto;
import ru.kpfu.itis.kashshapov.dto.DiscussionDto;
import ru.kpfu.itis.kashshapov.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscussionCommentDao implements Dao<DiscussionCommentDto> {
    //language=sql
    private static final String GET_BY_DISCUSSION = "select * from discussion_comments where discussion_id=? and main=?";
    //language=sql
    private static final String ADD = "insert into discussion_comments (description, time_created, user_id, discussion_id, main) values (?, ?, ?, ?, ?)";
    //language=sql
    private static final String DELETE = "delete from discussion_comments where id = ?";
    @Override
    public DiscussionCommentDto getById(Long id) {
        return null;
    }

    @Override
    public List<DiscussionCommentDto> getAll() {
        return null;
    }

    @Override
    public boolean add(DiscussionCommentDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, model.getDescription());
            statement.setString(2, model.getTimeCreated());
            statement.setLong(3, model.getUserId());
            statement.setLong(4, model.getDiscussionId());
            statement.setBoolean(5, model.getMain());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean update(DiscussionCommentDto model) {
        return false;
    }

    @Override
    public void delete(DiscussionCommentDto model) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<DiscussionCommentDto> getAllByDiscussionId(Long id) {
        try (Connection connection = DatabaseConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_DISCUSSION);
            statement.setLong(1, id);
            statement.setBoolean(2, true);
            ResultSet resultSet = statement.executeQuery();
            List<DiscussionCommentDto> comments = new ArrayList<>();
            if (resultSet != null) {
                while(resultSet.next()) {
                    comments.add(new DiscussionCommentDto(
                            resultSet.getLong("id"),
                            resultSet.getString("description"),
                            resultSet.getString("time_created"),
                            resultSet.getLong("user_id"),
                            resultSet.getLong("discussion_id"),
                            resultSet.getBoolean("main")
                    ));
                }
            }
            return comments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
