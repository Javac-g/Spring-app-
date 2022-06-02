package com.Maks.V5.Services;

import com.Maks.V5.Controller.Car;
import com.Maks.V5.Controller.ResponseDTO;

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
    public void log(String filename,ResponseDTO response){
        byte[] data = ("\nName: " + response.getName()+"\nId: " + response.getId()).getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try(FileOutputStream fileOutputStream = new FileOutputStream(filename + ".txt",true);
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename + ".dat",true))){

            byteArrayOutputStream.write(data);
            byteArrayOutputStream.writeTo(fileOutputStream);
            dataOutputStream.writeUTF("\nName: " + response.getName() + "\nId: " + response.getId());

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ResponseDTO Enum(RequestDTO request,ResponseDTO response){

        for (Car car:request.getCarlist()){
            switch (car.getValue()){
                case"L":
                    response.setCarEnum(CarEnum.LANOS);
                    break;
                case"T":
                    response.setCarEnum(CarEnum.THANOS);
                    break;
                case"A":
                    response.setCarEnum(CarEnum.ANANOS);
                    break;
            }
        }
        return response;

    }
}
