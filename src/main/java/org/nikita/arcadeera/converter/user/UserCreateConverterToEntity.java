package org.nikita.arcadeera.converter.user;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.converter.Converter;
import org.nikita.arcadeera.dto.request.UserCreateRequest;
import org.nikita.arcadeera.entity.User;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Log4j2
public class UserCreateConverterToEntity implements Converter<UserCreateRequest, User> {
    @Override
    public User convert(UserCreateRequest userCreateRequest) {
        if (Objects.isNull(userCreateRequest)) {
            return null;
        }
        return new User().setRegion(userCreateRequest.getRegion())
                .setAge(userCreateRequest.getAge())
                .setBalance(userCreateRequest.getBalance())
                .setName(userCreateRequest.getName());
    }
}
