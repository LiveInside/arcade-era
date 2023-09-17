package org.nikita.arcadeera.checks;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.entity.Game;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CheckNullGame implements CheckNull<Game> {
    @Override
    public void checkForNull(Game game) {
    }
}

