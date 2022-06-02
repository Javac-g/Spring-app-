package com.Maks.V5.Services;

import com.Maks.V5.Controller.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class Services {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){
        return msg;
    }
}
