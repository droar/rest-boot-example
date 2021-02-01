package com.droar.restex_svc.repository;

import java.util.List;
import com.droar.boot.fwk.base.service.GenericRepository;
import com.droar.restex_svc.entity.User;

/**
 * If we want to use spring query lookup, this is a good starting point.
 * Everything we call method here, will search for the worlds find + by + parameters + condition
 * 
 * The Interface UserRepository.
 */
public interface UserRepository extends GenericRepository<User, Integer>, UserRepositoryCustom {

  
  /**
   * Find by firstName containing.
   *
   * @param firstName the firstName
   * @return the list
   */
  List<User> findByFirstNameContaining(String firstName);
}
