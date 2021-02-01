package com.droar.restex_svc.util;

/**
 * The Class Validations.
 */
public class ValidationUtils {

  /**
   * Instantiates a new validation utils.
   */
  private ValidationUtils() {

  }

  /**
   * Checks if is int.
   *
   * @param strNum the str num
   * @return true, if is int
   */
  public static boolean isInt(String strNum) {
    Boolean isInt = false;
    try {
      @SuppressWarnings("unused")
      Integer i = Integer.parseInt(strNum);
      isInt = true;
    } catch (NumberFormatException | NullPointerException nfe) {
      return false;
    }
    return isInt;
  }

  /**
   * Validate id.
   *
   * @param id the id
   * @return the string
   */
  public static String validateId(String id, String token) {
    if (isInt(id)) {
      return id;
    } else if (id.equals("me")) {
      return token;
    } else {
      return null;
    }
  }


}
