package com.droar.restex_svc.util;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author droar
 *
 */
@Component
public class i18nUtils {

  /** The message resource. */
  @Autowired
  private ResourceBundleMessageSource messageSource;

  /**
   * Instantiates a new utils.
   */
  private i18nUtils() {
    // Public Constructor
  }

  /**
   * Gets the locale.
   *
   * @param locale the locale
   * @return the locale
   */
  public static Locale getLocale(String locale) {

    Locale l;

    if (locale == null || locale.trim().isEmpty()) {
      l = LocaleContextHolder.getLocale();
    } else {
      l = new Locale(locale);
    }

    return l;
  }

  /**
   * Get Message 
   * @param message
   * @return
   */
  public String getMessage(String message) {
    return this.messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
  }

}
