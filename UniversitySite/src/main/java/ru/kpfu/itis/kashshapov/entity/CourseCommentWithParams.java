package ru.kpfu.itis.kashshapov.entity;

import ru.kpfu.itis.kashshapov.dao.impl.CourseDaoImpl;
import ru.kpfu.itis.kashshapov.dao.impl.UniversityDaoImpl;
import ru.kpfu.itis.kashshapov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.kashshapov.dto.CourseCommentDto;
import ru.kpfu.itis.kashshapov.dto.CourseDto;
import ru.kpfu.itis.kashshapov.dto.UniversityDto;
import ru.kpfu.itis.kashshapov.dto.UserDto;

public class CourseCommentWithParams {
    private CourseCommentDto courseCommentDto;
    private UniversityDto universityDto;
    private CourseDto courseDto;
    private UserDto userDto;
    public CourseCommentWithParams(CourseCommentDto courseCommentDto){
        this.courseCommentDto = courseCommentDto;
        this.universityDto = new UniversityDaoImpl().getById(courseCommentDto.getUniversityId());
        this.userDto = new UserDaoImpl().getById(courseCommentDto.getUserId());
        this.courseDto = new CourseDaoImpl().getById(courseCommentDto.getCourseId());
    }

    public CourseCommentDto getCourseCommentDto() {
        return courseCommentDto;
    }

    public void setCourseCommentDto(CourseCommentDto courseCommentDto) {
        this.courseCommentDto = courseCommentDto;
    }

    public UniversityDto getUniversityDto() {
        return universityDto;
    }

    public void setUniversityDto(UniversityDto universityDto) {
        this.universityDto = universityDto;
    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
