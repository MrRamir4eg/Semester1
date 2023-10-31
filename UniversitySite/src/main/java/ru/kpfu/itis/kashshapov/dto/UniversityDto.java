package ru.kpfu.itis.kashshapov.dto;

public class UniversityDto {
    private Long id;
    private String name;
    private String description;
    private String gerbImg;
    private String addImg;

    public UniversityDto(String name, String description, String gerbImg, String addImg) {
        this.name = name;
        this.description = description;
        this.gerbImg = gerbImg;
        this.addImg = addImg;
    }

    public UniversityDto(Long id, String name, String description, String gerbImg, String addImg) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.gerbImg = gerbImg;
        this.addImg = addImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGerbImg() {
        return gerbImg;
    }

    public void setGerbImg(String gerbImg) {
        this.gerbImg = gerbImg;
    }

    public String getAddImg() {
        return addImg;
    }

    public void setAddImg(String addImg) {
        this.addImg = addImg;
    }
}
