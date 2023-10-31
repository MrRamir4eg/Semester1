package ru.kpfu.itis.kashshapov.dto;

public class CourseDto {
    private Long id;
    private String codeName;
    private String name;
    private String description;

    public CourseDto(Long id, String codeName, String name, String description) {
        this.id = id;
        this.codeName = codeName;
        this.name = name;
        this.description = description;
    }

    public CourseDto(String codeName, String name, String description) {
        this.codeName = codeName;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
