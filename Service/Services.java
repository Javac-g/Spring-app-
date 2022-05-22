package com.Maks.Service;

import com.Maks.Controller.Pet;
import com.Maks.Controller.ResponseDTO;
import com.fasterxml.jackson.core.io.DataOutputAsStream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Services {
    List<ResponseDTO> database = new ArrayList<>();

    public String print(String msg){
        return msg;
    }
    public void log(String filename,ResponseDTO user){

        byte[] data = ("\nName: " + user.getName() + "\nId: " + user.getId()).getBytes();

        ByteArrayOutputStream b = new ByteArrayOutputStream();

        try(DataOutputStream d = new DataOutputStream(new FileOutputStream(filename+".dat",true));
            FileOutputStream F = new FileOutputStream(filename+".txt",true))    {

            b.write(data);
            b.writeTo(F);
            d.writeUTF("\nName: " + user.getName() + "\nId: " + user.getId());

        }catch (IOException e){
            e.printStackTrace();

        }


    }

    public ResponseDTO E(RequestDTO request, ResponseDTO response){

        for (Pet pet:request.getPetlist()){

            switch (pet.getValue()){

                case "L":

                    response.setPet(Pet_Enum.LION);

                    break;

                case "T":

                    response.setPet(Pet_Enum.TIGER);

                    break;

                case "P":

                    response.setPet(Pet_Enum.PUMA);

                    break;

            }

        }

        return response;
    }

    public ResponseDTO Create(RequestDTO request){

        ResponseDTO response = new ResponseDTO();

        response.setName(request.getName());

        response.setId(request.getId());

        response.setSkill(request.getSkill());

        E(request,response);

        log("Created",response);

        database.add(response);

        return response;

    }

    public ResponseDTO Read(Integer id){

        for (ResponseDTO search: database){

            if (search.getId().equals(id)){

                log("Finded",search);

                return search;

            }
        }

        return null;
    }

    public ResponseDTO Update(Integer id, RequestDTO newUser){
        ResponseDTO up = Read(id);

        if(up != null){

            up.setName(newUser.getName());
            up.setId(newUser.getId());
            up.setSkill(newUser.getSkill());
            log("Updated",up);
            return up;
        }

        return null;

    }

    public Integer delete(Integer id){

        int Index = -1;

        for (int i = 0; i < database.size();i++){

            if (database.get(i).getId().equals(id)){

                Index = i;

            }

        }
        if (Index != -1){
            database.remove(Index);
            log("deleted",database.get(Index));
            return Index;
        }

        return null;
    }




}//end of class don't miss!
