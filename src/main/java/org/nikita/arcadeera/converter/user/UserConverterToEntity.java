package org.nikita.arcadeera.converter.user;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.nikita.arcadeera.exception.EmptyParam;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class UserConverterToEntity implements Converter<UserDTO, User> {
    @Override
    public User convert(UserDTO userDTO) {
        if (Objects.isNull(userDTO))
            throw new EmptyParam("Пустой параметр");
        return new User()
                .setId(userDTO.getId())
                .setRegion(userDTO.getRegion())
                .setAge(userDTO.getAge())
                .setBalance(userDTO.getBalance())
                .setName(userDTO.getName());
    }
}
