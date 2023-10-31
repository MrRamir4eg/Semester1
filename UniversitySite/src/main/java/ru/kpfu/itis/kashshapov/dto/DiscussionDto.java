package ru.kpfu.itis.kashshapov.dto;

public class DiscussionDto {
    private Long id;
    private String title;
    private String description;
    private String timeCreated;
    private Long user_id;

    public DiscussionDto(){

    }

    public DiscussionDto(Long id, String title, String description, String timeCreated, Long user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.timeCreated = timeCreated;
        this.user_id = user_id;
    }

    public DiscussionDto(String title, String description, String timeCreated, Long user_id) {
        this.title = title;
        this.description = description;
        this.timeCreated = timeCreated;
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }
}
