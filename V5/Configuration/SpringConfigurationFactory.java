package com.Maks.V5.Configuration;

import com.Maks.V5.Controller.ContRolleR;
import com.Maks.V5.Services.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")
    @Scope(value = "prototype")
    public Services servicesBean(){

        return new Services();

    }
    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public ContRolleR controllerBean(){

        return new ContRolleR(servicesBean());

    }
}
