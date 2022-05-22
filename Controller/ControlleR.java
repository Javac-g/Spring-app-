package com.Maks.Controller;

import com.Maks.Service.RequestDTO;
import com.Maks.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/VK")
public class ControlleR {

    public ControlleR(Services services) {

        this.services = services;

    }

    private Services services;

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO requestDTO){

         return services.Create(requestDTO);

    }
    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id){

        return services.Read(id);

    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO update(@RequestParam Integer id,@RequestBody RequestDTO requestDTO){

        return services.Update(id, requestDTO);

    }

    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestParam Integer id){

        return services.print("Was deleted person № - ") + services.delete(id);

    }

}
