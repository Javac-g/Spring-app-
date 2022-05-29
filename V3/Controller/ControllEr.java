package com.Maks.V3.Controller;

import com.Maks.V3.Service.RequestDTO;
import com.Maks.V3.Service.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
