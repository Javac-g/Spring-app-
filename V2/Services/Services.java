package com.Maks.V2.Services;

import com.Maks.V2.Controller.Pet;
import com.Maks.V2.Controller.ResponseDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Services {


    List<ResponseDTO> database = new ArrayList<>();

    public String print(String msg){

        return msg;

    }

    public void log(String filename, ResponseDTO user){

        byte[] data = ("\nName: " + user.getName() + "\nId: " + user.getId()).getBytes();

        ByteArrayOutputStream b = new ByteArrayOutputStream();

        try(FileOutputStream f = new FileOutputStream(filename + ".txt",true);

            DataOutputStream d = new DataOutputStream( new FileOutputStream(filename + ".dat" ,true))

        ){

            b.write(data);

            b.writeTo(f);

            d.writeUTF("\nName: " + user.getName() + "\nId: " + user.getId());

        }catch (IOException e){

            e.printStackTrace();

        }


    }

    public ResponseDTO E(RequestDTO request, ResponseDTO response){

        for (Pet pet:request.getPetlist()){

            switch (pet.getValue()){

                case"fast":

                    response.setPetEnum(PetEnum.HORSE);

                    break;

                case"guard":

                    response.setPetEnum(PetEnum.DOG);

                    break;

                case"sneak":

                    response.setPetEnum(PetEnum.SNAKE);

                    break;
            }
        }

        return response;
    }
}
