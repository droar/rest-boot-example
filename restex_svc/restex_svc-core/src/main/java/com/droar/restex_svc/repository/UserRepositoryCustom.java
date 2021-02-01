package com.droar.restex_svc.repository;

import java.util.List;
import com.droar.restex_svc.entity.User;


/**
 * The Interface UserRepositoryCustom.
 */

public interface UserRepositoryCustom {

  /**
   * Find users example.
   *
   * @param userName the username
   * @param career the career
   * @return the users
   */
  public List<User> findUsers(String userName, String career);
  
  /**
   * Find user.
   *
   * @param id the id
   * @return the user
   */
  public User findUser(Integer id);
}
