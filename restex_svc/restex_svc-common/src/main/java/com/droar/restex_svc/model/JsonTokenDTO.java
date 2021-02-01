package com.droar.restex_svc.model;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Instantiates a new json token DTO.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonTokenDTO implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 7011659023590705964L;

  /** The id. */
  private String id;

  /** The role. */
  private String role;

  /** The email. */
  private String email;

  /** The name. */
  private String name;

  /** The groups. */
  private List<String> groups;
}
