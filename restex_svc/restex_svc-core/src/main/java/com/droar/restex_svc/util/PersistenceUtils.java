package com.droar.restex_svc.util;


import java.util.ResourceBundle.Control;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * The Class PersistenceUtils.
 */
public class PersistenceUtils extends Control {


  /**
   * Unproxy in case is needed to force.
   *
   * @param <T> the generic type
   * @param proxied the proxied
   * @return the t
   */
  @SuppressWarnings("unchecked")
  public static <T> T unproxy(T proxied) {
    T entity = proxied;
    if (entity != null && entity instanceof Hibernate) {
      Hibernate.initialize(entity);
      entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
    }
    return entity;
  }

}
