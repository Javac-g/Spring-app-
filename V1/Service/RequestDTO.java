package com.Maks.V1.Service;

import com.Maks.V1.Controller.Pet;
import com.Maks.V1.Controller.Tool;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    String name;
    Integer id;
    Tool skill;
    List<Pet> petlist = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tool getSkill() {
        return skill;
    }

    public void setSkill(Tool skill) {
        this.skill = skill;
    }

    public List<Pet> getPetlist() {
        return petlist;
    }

    public void setPetlist(List<Pet> petlist) {
        this.petlist = petlist;
    }
}
