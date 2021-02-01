package com.droar.restex_svc.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import com.droar.restex_svc.entity.User;
import com.droar.restex_svc.model.svc_user.UserGetDetailDTO;
import com.droar.restex_svc.model.svc_user.UserGetDTO;

/**
 * The Class UserMapper.
 */
@Component
public class UserMapper {

  /**
   * 
   * @param lstUsers
   * @return
   */
  public List<UserGetDTO> transformToDTOList(List<User> lstUsers) {
    List<UserGetDTO> lstUsersDTO = new ArrayList<UserGetDTO>();

    if (CollectionUtils.isNotEmpty(lstUsers)) {
      lstUsers.stream().forEach(u -> {
        lstUsersDTO.add(new UserGetDTO(u.getId().toString(), u.getFirstName(), u.getLastName(), u.getCareer()));
      });

    }

    return lstUsersDTO;
  }

  /**
   * 
   * @param user
   * @return
   */
  public UserGetDetailDTO transformToDTO(User user) {
    UserGetDetailDTO userDTO = new UserGetDetailDTO();

    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setCareer(user.getCareer());

    return userDTO;
  }

}
