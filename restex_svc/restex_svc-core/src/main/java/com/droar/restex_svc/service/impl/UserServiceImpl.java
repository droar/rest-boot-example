package com.droar.restex_svc.service.impl;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.droar.boot.fwk.base.service.impl.GenericServiceBaseImpl;
import com.droar.restex_svc.entity.User;
import com.droar.restex_svc.exception.ExceptionHandler;
import com.droar.restex_svc.repository.UserRepository;
import com.droar.restex_svc.service.UserService;

/**
 * 
 * @author droar
 *
 */
@Service
public class UserServiceImpl extends GenericServiceBaseImpl<User, Integer, UserRepository> implements UserService {

  /** The exceptionHandler. */
  @SuppressWarnings("unused")
  @Autowired
  private ExceptionHandler exceptionHandler;

  @Override
  public List<User> findUsers(String userName, String career) {
    if (StringUtils.isNotBlank(userName)) {
      // Just for trying the query lookup from repository, we call it in case username is not empty
      return this.getRepo().findByFirstNameContaining(userName);
    } else {
      // Otherwise, we go to the normal querying
      return this.getRepo().findUsers(userName, career);
    }
  }

  @Override
  public User findUser(String strId) {
    // transform to integer from controller
    Integer id = NumberUtils.toInt(strId);

    return this.getRepo().findUser(id);
  }

}
