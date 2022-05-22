package com.Maks.Config;

import com.Maks.Controller.ControlleR;
import com.Maks.Service.Services;
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
