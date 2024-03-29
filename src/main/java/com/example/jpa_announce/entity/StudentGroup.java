package com.example.jpa_announce.entity;

import jakarta.persistence.*;

@Entity
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int group_id;
    private int group_name;
    @ManyToOne
    @JoinColumn(name = "announcement_id")
    private Announce group;

    public StudentGroup(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getGroup_name() {
        return group_name;
    }

    public void setGroup_name(int group_name) {
        this.group_name = group_name;
    }

    public Announce getGroup() {
        return group;
    }

    public void setGroup(Announce group) {
        this.group = group;
    }
}
