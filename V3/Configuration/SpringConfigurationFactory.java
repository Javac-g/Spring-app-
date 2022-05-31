package com.Maks.V3.Configuration;

import com.Maks.V3.Controller.ControllEr;
import com.Maks.V3.Service.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")
    @Scope(value = "prototype")
    Services servicesB(){

        return new Services();

    }
    @Bean(name = "Controller")
    @Scope(value = "prototype")
    ControllEr controllErB(){

        return  new ControllEr(servicesB());

    }




}
