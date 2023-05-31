package com.example.studentexam;

public class Student {
    private int id;
    private String name;
    private String grade;


    private String imageUrl;

    private String details;
    public Student(int id, String name, String  grade, String imageUrl, String details) {
        super();
        this.id = id;
        this.name = name;
        this.grade = grade;

        this.imageUrl = imageUrl;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
