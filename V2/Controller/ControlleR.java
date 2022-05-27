package com.Maks.V2.Controller;

import com.Maks.V2.Services.RequestDTO;
import com.Maks.V2.Services.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public class ControlleR {

    private Services services;

    public ControlleR(Services services){

        this.services = services;

    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestParam RequestDTO requestDTO){

        return services.create(requestDTO);

    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id){

        return services.read(id);

    }

    public ResponseDTO update(@RequestParam Integer id, @RequestBody RequestDTO requestDTO){

        return services.update(id,requestDTO);

    }
}
