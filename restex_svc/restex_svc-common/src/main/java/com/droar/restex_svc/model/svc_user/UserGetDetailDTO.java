package com.droar.restex_svc.model.svc_user;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class UserGetDetailDTO.
 *
 * @author droar
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGetDetailDTO implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 4076431417065020453L;

  /** The first name. */
  private String firstName;

  /** The last name. */
  private String lastName;

  /** The career. */
  private String career;
}
