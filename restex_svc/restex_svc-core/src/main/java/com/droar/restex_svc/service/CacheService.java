package com.droar.restex_svc.service;

import java.util.Optional;
import com.droar.restex_svc.entity.User;

public interface CacheService {

  /**
   * getCachedUserbyUsername
   * 
   * @param token
   * @param idMediador
   * @return
   */
  public Optional<User> getCachedUserByUserName(String userName);

}
