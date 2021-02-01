package com.droar.restex_svc.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.droar.restex_svc.assembler.UserResourceAssembler;
import com.droar.restex_svc.entity.User;
import com.droar.restex_svc.exception.ExceptionHandler;
import com.droar.restex_svc.mapper.UserMapper;
import com.droar.restex_svc.model.svc_user.UserGetDetailDTO;
import com.droar.restex_svc.model.svc_user.UserGetDTO;
import com.droar.restex_svc.service.UserService;
import com.droar.restex_svc.util.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE, RequestMethod.PUT})
@RequestMapping("/users")
public class UserController {

  /** The user service. */
  @Autowired
  private UserService userService;

  /** The user mapper. */
  @Autowired
  private UserMapper userMapper;

  /** The exception handler. */
  @Autowired
  private ExceptionHandler exceptionHandler;

  /** The assembler. */
  @Autowired
  private UserResourceAssembler userAssembler;

  @GetMapping
  public CollectionModel<UserGetDTO> getUsers(@RequestHeader("Authorization") String token,
      @RequestHeader(value = "Accept-Language", defaultValue = Constants.Controller.DEFAULT_LANGUAGE,
          required = false) String language,
      @RequestParam(value = "userName", required = false) String userName,
      @RequestParam(value = "career", required = false) String career) {
    log.info("[API USERS]: [GET] /users: Getting users by filters -> " + userName);

    CollectionModel<UserGetDTO> lstResultUsers = null;

    // We call to the service, to handle logic and eventually search the repository
    List<User> lstFoundUsers = this.userService.findUsers(userName, career);

    if (CollectionUtils.isEmpty(lstFoundUsers)) {
      log.error("No userwith this pattern has been found -> " + userName + '/' + career);
      throw this.exceptionHandler.getHttpException(HttpStatus.BAD_REQUEST);
    }

    // We map entities to DTO and we add their links
    List<UserGetDTO> lstDTOitems = this.userMapper.transformToDTOList(lstFoundUsers);

    // We assemble the HATEOAS Links
    List<UserGetDTO> lstAssembledDTO = lstDTOitems.stream().map(d -> this.userAssembler.toModel(d)).collect(Collectors.toList());

    // We add the links
    lstResultUsers = CollectionModel.of(lstAssembledDTO);

    return lstResultUsers;
  }

  @GetMapping(Constants.UserController.GET_USER_BY_ID)
  public RepresentationModel<?> getUser(@RequestHeader("Authorization") String token,
      @RequestHeader(value = "Accept-Language", defaultValue = Constants.Controller.DEFAULT_LANGUAGE,
          required = false) String language,
      @PathVariable(value = "id", required = false) String strId) {
    log.info("[API USERS]: [GET] /users/{id}: Getting user by id -> " + strId);

    RepresentationModel<?> resultUser = null;

    User foundUser = this.userService.findUser(strId);

    if (foundUser == null) {
      log.error("No userwith this pattern has been found -> " + strId);
      throw this.exceptionHandler.getHttpException(HttpStatus.BAD_REQUEST);
    }

    // We map entities to DTO and we add their links
    UserGetDetailDTO dtoUser = this.userMapper.transformToDTO(foundUser);

    // We add the links
    resultUser = RepresentationModel.of(dtoUser);

    return resultUser;
  }

}
