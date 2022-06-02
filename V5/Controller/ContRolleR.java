package com.Maks.V5.Controller;

import com.Maks.V5.Services.Services;
import org.springframework.web.bind.annotation.RestController;

@RestController("/rest")
public class ContRolleR {
    private Services services;

    public ContRolleR(Services services) {
        this.services = services;
    }
}
