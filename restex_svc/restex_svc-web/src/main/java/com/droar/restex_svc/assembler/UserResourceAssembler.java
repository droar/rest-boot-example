package com.droar.restex_svc.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.droar.restex_svc.controller.UserController;
import com.droar.restex_svc.model.svc_user.UserGetDTO;

/**
 * 
 * @author droar
 *
 */
@Component
public class UserResourceAssembler implements RepresentationModelAssembler<UserGetDTO, UserGetDTO> {

  @Override
  public UserGetDTO toModel(UserGetDTO userDTO) {

    Link selfLink = linkTo(UserController.class).slash(userDTO.getId()).withSelfRel();
    userDTO.add(selfLink);

    return userDTO;
  }
}
