package com.Maks.V1.Controller;

import com.Maks.V1.Service.Pet_Enum;

public class ResponseDTO {

    String name;

    Integer id;

    Tool skill;

    Pet_Enum pet;

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

    public Pet_Enum getPet() {
        return pet;
    }

    public void setPet(Pet_Enum pet) {
        this.pet = pet;
    }
}
