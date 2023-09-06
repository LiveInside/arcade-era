package org.nikita.arcadeera.converter;

import org.nikita.arcadeera.dto.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO> {
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRegion(user.getRegion());
        userDTO.setAge(user.getAge());
        userDTO.setBalance(user.getBalance());
        userDTO.setName(user.getName());
        userDTO.setGame(userDTO.getGame());
        return userDTO;
    }
}
