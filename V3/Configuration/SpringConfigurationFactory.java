package com.Maks.V3.Configuration;

import com.Maks.V3.Controller.ControllEr;
import com.Maks.V3.Service.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationFactory {

    @Bean
    Services servicesB(){

        return new Services();

    }
    @Bean
    ControllEr controllErB(){

        return  new ControllEr(servicesB());

    }




}
