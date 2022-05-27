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

    public ResponseDTO create(RequestDTO requestDTO){

        ResponseDTO user = new ResponseDTO();

        user.setName(requestDTO.getName());

        user.setId(requestDTO.getId());

        user.setTool(requestDTO.getTool());

        E(requestDTO , user);

        log("created" , user);

        database.add(user);

        return user;

    }


    public ResponseDTO read(Integer id){

        for (ResponseDTO search : database){

            if (search.getId().equals(id)){

                log("searched",search);

                return search;
            }

        }
        return null;
    }

    public ResponseDTO update(Integer id, RequestDTO json){
        ResponseDTO newUser = read(id);

        if (newUser != null){

            newUser.setName(json.getName());

            newUser.setId(json.getId());

            newUser.setTool(json.getTool());

            E(json,newUser);

            log("updated",newUser);

            return newUser;
        }
        return null;
    }
    public Integer delete(Integer id){
        int remove = -1;

        for (int i = 0; i < database.size(); i++){

            if (database.get(i).getId().equals(id)){
                remove = i;
                log("removed",database.get(remove));

            }
        }
        if (remove != -1){

            database.remove(remove);
            return remove;
        }
        return null;
    }
}//EOF
