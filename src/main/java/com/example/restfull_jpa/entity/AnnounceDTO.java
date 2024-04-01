package com.example.restfull_jpa.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class AnnounceDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cafedra_id;
    private String employee;
    private String auditory;
    private String content;
    private String date;
    private String startTime;
    private String endTime;
    @OneToMany(mappedBy = "announceDTO",cascade = CascadeType.ALL)
    private List<commentDTO> commentDTOs;

    public AnnounceDTO(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getAuditory() {
        return auditory;
    }

    public void setAuditory(String auditory) {
        this.auditory = auditory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getCafedra_id() {
        return cafedra_id;
    }

    public void setCafedra_id(int cafedra_id) {
        this.cafedra_id = cafedra_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}