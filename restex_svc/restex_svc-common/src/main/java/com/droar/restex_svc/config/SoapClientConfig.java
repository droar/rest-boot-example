package com.droar.restex_svc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import com.droar.boot.fwk.base.client.SOAPClient;

/**
 * 
 * @author Damian
 *
 */
@Configuration
public class SoapClientConfig {
  
  // TODO: Move this to an annotated property value.
  private final static String PACKAGES_TO_SCAN = "com.droar.restex_svc.ws";
  
  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this is the package name specified in the <generatePackage> specified in
    // pom.xml
    marshaller.setPackagesToScan(PACKAGES_TO_SCAN);
    return marshaller;
  }

  @Bean
  public SOAPClient soapConnector(Jaxb2Marshaller marshaller) {
    SOAPClient client = new SOAPClient();
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }
}
