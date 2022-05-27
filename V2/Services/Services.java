package com.Maks.V2.Services;

import com.Maks.V2.Controller.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class Services {


    List<ResponseDTO> database = new ArrayList<>();

    public String print(String msg){

        return msg;

    }

    public ResponseDTO log(String filename, ResponseDTO user){

        byte[] data = ("").getBytes();


    }
}
