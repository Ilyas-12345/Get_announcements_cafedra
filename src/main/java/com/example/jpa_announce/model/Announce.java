package com.example.jpa_announce.model;

import java.util.List;
import java.util.stream.Collectors;

public class Announce {
    private Long id;
    private int cafedra_id;
    private List<Group> groups;
    public static Announce toModel(com.example.jpa_announce.entity.Announce entity){
        Announce model = new Announce();
        model.setId(entity.getId());
        model.setCafedra_id(entity.getCafedra_id());
        //здесь мы преобразовываем список в stream, map итерируется  по массиву и вызывает to model для каждого
        //элемента и коллектом обратно к листу,(из массива entity в массив model
        model.setGroups(entity.getStudentGroup().stream().map(Group::toModel).collect(Collectors.toList()));
        return model;
    }

    public Announce() {
    }

    public Long getId() {
        return id;
    }

    public int getCafedra_id() {
        return cafedra_id;
    }

    public void setCafedra_id(int cafedra_id) {
        this.cafedra_id = cafedra_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
