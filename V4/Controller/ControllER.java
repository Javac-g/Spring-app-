package com.Maks.V4.Controller;

import com.Maks.V4.Services.RequestDTO;
import com.Maks.V4.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/www")
public class ControllER {

    @Autowired
    public Services services;

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO addData(@RequestBody RequestDTO json){

        return services.create(json);

    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO findData(@RequestParam Integer id){

        return services.read(id);

    }
    @PutMapping(value = "/u",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO updateData(@RequestParam Integer id, @RequestBody RequestDTO json){

        return services.update(id,json);

    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestParam Integer id){

        return services.print("Was deleted person № - ") + services.delete(id);

    }






}
