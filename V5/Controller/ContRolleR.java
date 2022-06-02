package com.Maks.V5.Controller;

import com.Maks.V5.Services.RequestDTO;
import com.Maks.V5.Services.Services;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest")
public class ContRolleR {
    private Services services;

    public ContRolleR(Services services) {
        this.services = services;
    }

    @PostMapping(value = "/a",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO add(@RequestBody RequestDTO requestDTO){

        return services.create(requestDTO);

    }

    @GetMapping(value = "/f",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO find(@RequestParam Integer id){

        return services.read(id);

    }
    @PutMapping(value = "/u", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO update(@RequestParam Integer id, @RequestBody RequestDTO requestDTO){
        return services.update(id, requestDTO);

    }
    @DeleteMapping(value = "/d",produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@RequestParam Integer id){

        return services.print("Was deleted Number: ") +  services.delete(id);
    }
}
