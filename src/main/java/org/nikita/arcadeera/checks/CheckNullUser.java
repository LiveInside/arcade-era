package org.nikita.arcadeera.checks;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.entity.User;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CheckNullUser implements CheckNull<User> {
    @Override
    public void checkForNull(User user) {
    }
}
