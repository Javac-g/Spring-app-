package com.Maks.V3.Controller;

import com.Maks.V3.Service.RequestDTO;
import com.Maks.V3.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/www")
public class ControllEr {


    private Services services;

    public ControllEr(Services services) {

        this.services = services;
    }


    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addData(@RequestBody RequestDTO requestDTO){

        return services.create(requestDTO);

    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findData(@RequestParam Integer id){

        return services.read(id);

    }

    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateData(@RequestParam Integer id, @RequestBody RequestDTO requestDTO){

        return services.update(id, requestDTO);

    }

    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteData(@RequestParam Integer id){

        return services.print("Deleted person №" ) + services.delete(id);
    }
}
