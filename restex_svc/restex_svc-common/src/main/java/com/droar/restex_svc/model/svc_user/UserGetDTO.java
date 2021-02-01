package com.droar.restex_svc.model.svc_user;

import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data

/**
 * 
 * @author droar
 *
 */
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "items")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGetDTO extends RepresentationModel<UserGetDTO> implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 4076431417065020453L;

  /** The id. */
  private String id;
  
  /** The first name. */
  private String firstName;

  /** The last name. */
  private String lastName;

  /** The career. */
  private String career;

  /**
   * @param id
   * @param firstName
   * @param lastName
   * @param career
   */
  public UserGetDTO(String id, String firstName, String lastName, String career) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.career = career;
  }


}
