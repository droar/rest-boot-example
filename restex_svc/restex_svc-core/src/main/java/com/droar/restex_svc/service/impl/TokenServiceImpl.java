package com.droar.restex_svc.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionTimedOutException;
import org.springframework.transaction.annotation.Transactional;
import com.droar.boot.fwk.base.util.WebUtils;
import com.droar.restex_svc.exception.ExceptionHandler;
import com.droar.restex_svc.model.JsonTokenDTO;
import com.droar.restex_svc.service.CacheService;
import com.droar.restex_svc.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(readOnly = false, timeout = Constants.QUERY_TIMEOUT)
public class TokenServiceImpl {

  /** The exception handler. */
  @Autowired
  private ExceptionHandler exceptionHandler;

  /** The cache service, if we need to cache something. */
  @SuppressWarnings("unused")
  @Autowired
  private CacheService cacheService;

  public JsonTokenDTO isTokenValid(String token) throws TransactionTimedOutException {
    JsonTokenDTO jsonTokenDTO = null;

    if (StringUtils.isNotEmpty(token)) {
      try {
        // We decrypt the token
        String decodedJSON = WebUtils.getDecodedJsonObject(token).toString();
        jsonTokenDTO = new ObjectMapper().readValue(decodedJSON, JsonTokenDTO.class);
      }catch(Exception e) {
        log.error("Error unparsing token JSON: " + e.getMessage());
        throw this.exceptionHandler.getHttpException(HttpStatus.UNAUTHORIZED);
      }
    }
    return jsonTokenDTO;
  }

}
