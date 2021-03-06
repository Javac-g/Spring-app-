package com.Maks.V2.Controller;

import com.Maks.V2.Services.RequestDTO;
import com.Maks.V2.Services.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/www")
public class ControlleR {

    private Services services;

    public ControlleR(Services services){

        this.services = services;

    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO add(@RequestBody RequestDTO requestDTO){

        return services.create(requestDTO);

    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO find(@RequestParam Integer id){

        return services.read(id);

    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO update(@RequestParam Integer id, @RequestBody RequestDTO requestDTO){

        return services.update(id,requestDTO);

    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@RequestParam Integer id){

        return services.print("Was deleted person №") + services.delete(id);

    }
}
