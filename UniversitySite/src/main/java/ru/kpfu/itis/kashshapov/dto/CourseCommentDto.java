package ru.kpfu.itis.kashshapov.dto;

public class CourseCommentDto {
    private Long id;
    private String description;
    private String timeCreated;
    private Boolean positive;
    private Long userId;
    private Long courseId;
    private Long universityId;

    public CourseCommentDto() {
    }

    public CourseCommentDto(String description, String timeCreated, Boolean positive, Long userId, Long courseId, Long universityId) {
        this.description = description;
        this.timeCreated = timeCreated;
        this.positive = positive;
        this.userId = userId;
        this.courseId = courseId;
        this.universityId = universityId;
    }

    public CourseCommentDto(Long id, String description, String timeCreated, Boolean positive, Long userId, Long courseId, Long universityId) {
        this.id = id;
        this.description = description;
        this.timeCreated = timeCreated;
        this.positive = positive;
        this.userId = userId;
        this.courseId = courseId;
        this.universityId = universityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Boolean getPositive() {
        return positive;
    }

    public void setPositive(Boolean positive) {
        this.positive = positive;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }
}
