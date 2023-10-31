package ru.kpfu.itis.kashshapov.entity;

import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.DiscussionCommentDto;
import ru.kpfu.itis.kashshapov.dto.UserDto;

public class DiscussionCommentAndUser {
    private DiscussionCommentDto commentDto;
    private UserDto userDto;
    public DiscussionCommentAndUser(DiscussionCommentDto commentDto){
        this.commentDto = commentDto;
        this.userDto = new UserDaoImpl().getById(commentDto.getUserId());
    }

    public DiscussionCommentDto getCommentDto() {
        return commentDto;
    }

    public void setCommentDto(DiscussionCommentDto commentDto) {
        this.commentDto = commentDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
