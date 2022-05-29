package com.Maks.V3.Service;

import com.Maks.V3.Controller.ResponseDTO;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Services {

    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){

        return msg;

    }

    public void log(String filename,ResponseDTO responseDTO){

        byte[] data = ("\nName: " + responseDTO.getName() + "\nId: " + responseDTO.getId()).getBytes();

        ByteArrayOutputStream b = new ByteArrayOutputStream();

        try(FileOutputStream f = new FileOutputStream(filename+".txt",true);

            DataOutputStream d = new DataOutputStream(new FileOutputStream(filename+".dat",true))
        ){

            b.write(data);

            b.writeTo(f);

            d.writeUTF("\nName: " + responseDTO.getName() + "\nId: " + responseDTO.getId());

        }catch (IOException e){

            e.printStackTrace();

        }


    }

    public ResponseDTO E(RequestDTO request, ResponseDTO response){
        for (Car car : re)
    }

}//EOF
