package com.example.jpa_announce.model;

import com.example.jpa_announce.entity.StudentGroup;

public class Group {
    private Long id;
    private int group_id;
    private int group_name;

    public static Group toModel(StudentGroup entity){
        Group model = new Group();
        model.setId(entity.getId());
        model.setGroup_id(entity.getGroupId());
        model.setGroup_name(entity.getGroupName());
        return model;
    }

    public Group(){
    }

    public int getGroup_name() {
        return group_name;
    }

    public void setGroup_name(int group_name) {
        this.group_name = group_name;
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
}
