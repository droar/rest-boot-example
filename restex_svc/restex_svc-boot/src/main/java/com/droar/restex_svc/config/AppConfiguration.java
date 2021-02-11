package com.droar.restex_svc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({
  "classpath:/spring/restex_svc-boot.xml",
  "classpath:/spring/restex_svc-env.xml",
  "classpath:/spring/restex_svc-web.xml", 
  "classpath:/spring/restex_svc-core.xml", 
  "classpath:/spring/restex_svc-core-persistence-jpa.xml",
  "classpath:/spring/restex_svc-common.xml"
    })
@EntityScan(basePackages = {
    "com.droar.restex_svc.entity", 
    "com.droar.boot.fwk.base.entity"
    })
public class AppConfiguration {

  /** This place is for us to put java beans as usual**/
  
  @Bean
  public String iAmJustADummyBean() {
    return "IAmADummyBean";
  }
}
