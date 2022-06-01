package com.Maks.V4.Services;

import com.Maks.V4.Controller.ResponseDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Services {
    List<ResponseDTO> datalist = new ArrayList<>();

    public String print(String msg){

        return msg;

    }
    public void log(String filename, ResponseDTO user){

        byte[] data = ("\nName: " + user.getName()+"\nId: " + user.getId()).getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try(FileOutputStream fileOutputStream = new FileOutputStream(filename+".txt",true);
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename+".txt",true))) {

            byteArrayOutputStream.write(data);

            dataOutputStream.writeUTF("\nName: " + user.getName()+"\nId: " + user.getId());

            byteArrayOutputStream.writeTo(fileOutputStream);


        }catch (IOException e){

            e.printStackTrace();

        }

    }



}
