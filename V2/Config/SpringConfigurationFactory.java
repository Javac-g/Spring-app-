package com.Maks.V2.Config;


import com.Maks.V2.Controller.ControlleR;
import com.Maks.V2.Services.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationFactory {
   @Bean
   public Services servicesBEAN(){

        return  new Services();
   }
    @Bean 
    public ControlleR controlleRBEAN(){

        return new ControlleR(servicesBEAN());
    }



}
