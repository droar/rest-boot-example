package com.droar.restex_svc.service;

import java.util.List;
import com.droar.boot.fwk.base.service.GenericServiceBase;
import com.droar.restex_svc.entity.User;
import com.droar.restex_svc.repository.UserRepository;

/**
 * 
 * @author droar
 *
 */
public interface UserService extends GenericServiceBase<User, Integer, UserRepository> {


  /**
   * Find users
   * 
   * @param userName
   * @param career
   * @return users
   */
  public List<User> findUsers(String userName, String career);
  
  /**
   * Find user.
   *
   * @param id the id
   * @return the user
   */
  public User findUser(String id);

}
