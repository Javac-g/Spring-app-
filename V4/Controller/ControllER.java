package com.Maks.V4.Controller;

import com.Maks.V4.Services.RequestDTO;
import com.Maks.V4.Services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/www")
public class ControllER {


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





}
