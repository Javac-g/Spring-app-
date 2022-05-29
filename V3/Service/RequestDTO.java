package com.Maks.V3.Service;

import com.Maks.V2.Controller.Tool;
import com.Maks.V3.Controller.Car;

import java.util.ArrayList;
import java.util.List;

public class RequestDTO {
    String name;
    Integer id;

    Tool tool;

    List<Car> carlist = new ArrayList<>();

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public List<Car> getCarlist() {
        return carlist;
    }

    public void setCarlist(List<Car> carlist) {
        this.carlist = carlist;
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
