package com.droar.restex_svc.service.impl;

import java.util.Optional;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import com.droar.restex_svc.entity.User;
import com.droar.restex_svc.service.CacheService;


/**
 * In case we want to use cache. 
 * 
 * @author droar
 *
 */
@Service
public class CacheServiceImpl implements CacheService {

  //Autowired and dependency required
  private CacheManager cacheManager;

  @Override
  public Optional<User> getCachedUserByUserName(String userName) {
    return Optional.ofNullable(cacheManager.getCache("users")).map(c -> c.get(userName, User.class));
  }

}
