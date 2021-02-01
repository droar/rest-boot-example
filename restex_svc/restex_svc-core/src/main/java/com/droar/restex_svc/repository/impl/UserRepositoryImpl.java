package com.droar.restex_svc.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.droar.restex_svc.entity.QUser;
import com.droar.restex_svc.entity.User;
import com.droar.restex_svc.exception.ExceptionHandler;
import com.droar.restex_svc.repository.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;


/**
 * The Class UserRepositoryImpl.
 * 
 * @author droar
 *
 */
@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

  /** The exceptionHandler. */
  @Autowired
  private ExceptionHandler exceptionHandler;

  /** The entity manager. */
  @PersistenceContext
  private EntityManager entityManager;

  public List<User> findUsers(String userName, String career) {
    List<User> lstUsers = null;
    try {

      QUser qUser = QUser.user;

      JPAQuery<User> query = new JPAQuery<User>(this.entityManager);

      query.select(qUser);

      query.from(qUser);

      // Username Filter
      if (StringUtils.isNotBlank(userName))
        query.where(qUser.firstName.like(userName));
      // Career Filter
      if (StringUtils.isNotBlank(career))
        query.where(qUser.career.eq(career));

      query.orderBy(qUser.id.desc());

      // We fetch the results
      lstUsers = query.fetch();

    } catch (Exception e) {
      log.error("There's been an error when querying users by patterns");
      log.error(e.getMessage());
      throw this.exceptionHandler.getHttpException(HttpStatus.BAD_REQUEST);
    }

    return lstUsers;
  }

  public User findUser(Integer id) {
    User resultUser = null;
    
    Validate.notNull(id, "Finding users need a valid no null id");
    
    try {

      QUser qUser = QUser.user;

      JPAQuery<User> query = new JPAQuery<User>(this.entityManager);

      query.select(qUser);

      query.from(qUser);

      // id Filter
      query.where(qUser.id.eq(id));

      // We fetch the result
      resultUser = query.fetchFirst();

    } catch (Exception e) {
      log.error("There's been an error when recovering users by id: " + id);
      log.error(e.getMessage());
      throw this.exceptionHandler.getHttpException(HttpStatus.BAD_REQUEST);
    }

    return resultUser;
  }
}
