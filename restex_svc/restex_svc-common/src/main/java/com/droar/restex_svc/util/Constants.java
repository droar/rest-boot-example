package com.droar.restex_svc.util;


/**
 * Constants to be used for the whole project
 * 
 * @author droar
 *
 */
public class Constants {

  /**
   * Instantiates a new constants.
   */
  private Constants() {
    // private Constructor
  }

  /** The Constant TIMEOUT. */
  public static final int QUERY_TIMEOUT = 1000;

  /** The Constant EMBEDDED. */
  public static final String JSON_EMBEDDED = "_embedded";

  /** The Constant JSON_ITEMS. */
  public static final String JSON_ITEMS = "items";

  /**
   * The Class Controller.
   */
  public static class Controller {

    /**
     * Instantiates a new controller.
     */
    private Controller() {
      // private Constructor
    }

    /** The Constant DEFAULT_LANGUAGE. */
    public static final String DEFAULT_LANGUAGE = "es";

    /** The Constant DEFAULT_LIMIT. */
    public static final String DEFAULT_LIMIT = "20";

    /** The Constant DEFAULT_OFFSET. */
    public static final String DEFAULT_OFFSET = "0";
  }

  /**
   * The Class CommonExpressions.
   */
  public static class CommonExpressions {

    /**
     * Instantiates a new CommonExpressions.
     */
    private CommonExpressions() {
      // private Constructor
    }

    /** The Constant YES_CAPITAL_CHAR. */
    public static final String YES_CAPITAL_CHAR = "S";

    /** The Constant NO_CAPITAL_CHAR. */
    public static final String NO_CAPITAL_CHAR = "N";

    /** The Constant LANG_ES. */
    public static final String LANG_ES = "es";

    /** The Constant LANG_EU. */
    public static final String LANG_EU = "eu";

    /** The Constant ZERO_STRING. */
    public static final String ZERO_STRING = "0";

  }


  /**
   * Exception codes
   *
   */
  public static class ExceptionCode {

    /**
     * Instantiates a new exceptionCode.
     */
    private ExceptionCode() {
      // private Constructor
    }

    /** The Constant CODE_BAD_REQUEST. */
    public static final int CODE_BAD_REQUEST = 400;

    /** The Constant CODE_UNAUTHORIZED. */
    public static final int CODE_UNAUTHORIZED = 401;

    /** The Constant CODE_FORBIDDEN. */
    public static final int CODE_FORBIDDEN = 403;

    /** The Constant CODE_NOT_FOUND. */
    public static final int CODE_NOT_FOUND = 404;

    /** The Constant CODE_UNPROCESSABLE_ENTITY. */
    public static final int CODE_UNPROCESSABLE_ENTITY = 422;

    /** The Constant CODE_INTERNAL_SERVER_ERROR. */
    public static final int CODE_INTERNAL_SERVER_ERROR = 500;

    /** The Constant CODE_GATEWAY_TIMEOUT. */
    public static final int CODE_GATEWAY_TIMEOUT = 504;

    /** The Constant BAD_REQUEST. */
    public static final int BAD_REQUEST = 1;

    /** The Constant NOT_FOUND. */
    public static final int NOT_FOUND = 2;

    /** The Constant FORBIDDEN. */
    public static final int FORBIDDEN = 3;

    /** The Constant INTERNAL_SERVER_ERROR. */
    public static final int INTERNAL_SERVER_ERROR = 4;

    /** The Constant UNAUTHORIZED. */
    public static final int UNAUTHORIZED = 5;

    /** The Constant UNAUTHORIZED. */
    public static final int GATEWAY_TIMEOUT = 6;

  }

  /**
   * The Class TokenController.
   */
  public static class TokenController {

    /**
     * Instantiates a new token controller.
     */
    private TokenController() {
      // private Constructor
    }

    /** The Constant ROLE. */
    public static final String ROLE = "ROLE";

  }

  /**
   * The Class UserController.
   */
  public static class UserController {

    /**
     * 
     */
    private UserController() {
      // private Constructor
    }

    /** The Constant GET_USER_BY_ID. */
    public static final String GET_USER_BY_ID = "/{id}";

  }

  /**
   * The Class TypeMaster
   */
  public static class TypeMaster {

    /**
     * Instantiates a new TypeMaster
     */
    private TypeMaster() {
      // private Constructor
    }
  }

  /**
   * The Class MimeType.
   */
  public static class MimeType {

    /**
     * Instantiates a new mime type.
     */
    private MimeType() {

    }

    /** The Constant PDF. */
    public static final String PDF = "application/pdf";

  }
}
