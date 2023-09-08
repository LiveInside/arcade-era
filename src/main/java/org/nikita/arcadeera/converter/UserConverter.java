package org.nikita.arcadeera.converter;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.dto.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class UserConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO toDTO(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setRegion(user.getRegion())
                .setAge(user.getAge())
                .setBalance(user.getBalance())
                .setName(user.getName());
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        return new User()
                .setId(userDTO.getId())
                .setRegion(userDTO.getRegion())
                .setAge(userDTO.getAge())
                .setBalance(userDTO.getBalance())
                .setName(userDTO.getName());
    }
}
