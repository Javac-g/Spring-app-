package com.Maks.V1.Config;

import com.Maks.V1.Controller.ControlleR;
import com.Maks.V1.Service.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfigurationFactory {

    @Bean
    public Services servicesBean(){

        return new Services();

    }
    @Bean
    public ControlleR controllerBean(){

        return new ControlleR(servicesBean());

    }



}
