package com.droar.restex_svc.util;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author droar
 *
 */
@Slf4j
public class WSUtils {



  /**
   * Parses and marshalls an imput
   * 
   * @param <T>
   * @param pojoToString
   * @param clazz
   * @return
   */
  public static <T extends Serializable> String parseInput(T pojoToString, Class<T> clazz) {
    String res = "";
    if (pojoToString != null) {
      try {
        JAXBContext jaxbOut = JAXBContext.newInstance(clazz);
        Marshaller pojoToXML = jaxbOut.createMarshaller();
        pojoToXML.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        pojoToXML.marshal(pojoToString, writer);
        res = writer.toString();
        res = res.trim();
      } catch (JAXBException e) {
        log.error("Error parsing pojo to XML", e);
      }
    }
    return res;
  }


  /**
   * Parses the jaxbx result marshalling.
   * 
   * @param <T>
   * @param result
   * @param clazz
   * @return
   */
  @SuppressWarnings("unchecked")
  public static <T extends Serializable> T parseResultWS(String result, Class<T> clazz) {
    T parsedResult = null;
    if (result != null) {
      try {
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(result);
        parsedResult = (T) unmarshaller.unmarshal(reader);
      } catch (Exception e) {
        log.error("Error parsing XML to Pojo", e);
      }
    }
    return parsedResult;
  }

}
