package com.Maks.V3.Controller;

import com.Maks.V3.Service.Car_Enum;

public class ResponseDTO {

    String name;
    Integer id;
    Tool tool;

    Car_Enum carEnum;

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public Car_Enum getCarEnum() {
        return carEnum;
    }

    public void setCarEnum(Car_Enum carEnum) {
        this.carEnum = carEnum;
    }

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
}
