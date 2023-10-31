package ru.kpfu.itis.kashshapov.entity;

import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.DiscussionDto;
import ru.kpfu.itis.kashshapov.dto.UserDto;

public class DiscussionAndUser {
    private DiscussionDto discussionDto;
    private UserDto userDto;

    public DiscussionAndUser(DiscussionDto model){
        this.discussionDto = model;
        this.userDto = new UserDaoImpl().getById(model.getUser_id());
    }

    public DiscussionDto getDiscussionDto() {
        return discussionDto;
    }

    public void setDiscussionDto(DiscussionDto discussionDto) {
        this.discussionDto = discussionDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
