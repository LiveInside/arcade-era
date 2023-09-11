package org.nikita.arcadeera.converter.user;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.response.UserDTO;
import org.nikita.arcadeera.entity.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class UserConverterToDTO implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User user) {
        if (Objects.isNull(user)) {
            log.info("User не найден");
            return null;
        }
        return new UserDTO()
                .setId(user.getId())
                .setRegion(user.getRegion())
                .setAge(user.getAge())
                .setBalance(user.getBalance())
                .setName(user.getName());
    }
}
