package ru.kpfu.itis.kashshapov.dto;

public class DiscussionCommentDto {
    private Long id;
    private String description;
    private String timeCreated;
    private Long userId;
    private Long discussionId;
    private Boolean main;
    public DiscussionCommentDto(){

    }

    public DiscussionCommentDto(Long id, String description, String timeCreated, Long userId, Long discussionId, Boolean main) {
        this.id = id;
        this.description = description;
        this.timeCreated = timeCreated;
        this.userId = userId;
        this.discussionId = discussionId;
        this.main = main;
    }

    public DiscussionCommentDto(String description, String timeCreated, Long userId, Long discussionId, Boolean main) {
        this.description = description;
        this.timeCreated = timeCreated;
        this.userId = userId;
        this.discussionId = discussionId;
        this.main = main;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Long discussionId) {
        this.discussionId = discussionId;
    }

    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }
}
