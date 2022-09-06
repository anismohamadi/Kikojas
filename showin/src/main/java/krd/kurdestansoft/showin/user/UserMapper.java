package krd.kurdestansoft.showin.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    List<User> toUserList(List<UserDTO> userDTO);
    List<UserDTO> toUserDTOS(List<User> users);



}
