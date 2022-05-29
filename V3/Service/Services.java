package com.Maks.V3.Service;

import com.Maks.V3.Controller.Car;
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

        for (Car car : request.getCarlist()){

            switch (car.getValue()){

                case "P":

                    response.setCarEnum(Car_Enum.PORSHE);

                    break;

                case "F":

                    response.setCarEnum(Car_Enum.FERRARI);

                    break;

                case "A":

                    response.setCarEnum(Car_Enum.AUDI);

                    break;

            }
        }
        return response;
    }

    public ResponseDTO create(RequestDTO data){

        ResponseDTO user = new ResponseDTO();

        user.setName(data.getName());
        user.setId(data.getId());
        user.setTool(data.getTool());

        E(data,user);

        log("Create_3",user);

        datalist.add(user);
        return user;

    }

    public ResponseDTO read(Integer id){

        for (ResponseDTO search : datalist){
            if(search.getId().equals(id)){
                log("Search_3",search);
                return search;
            }
        }
        return null;



    }
    public ResponseDTO update(Integer id, RequestDTO upData){
        ResponseDTO user = read(id);

        if(user != null){
            user.setName(upData.getName());
            user.setId(upData.getId());
            user.setTool(upData.getTool());
            E(upData,user);
            log("Updated_3",user);
            return user;
        }
        return null;

    }

}//EOF
