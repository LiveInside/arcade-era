package org.nikita.arcadeera.checks;

import lombok.extern.log4j.Log4j2;
import org.nikita.arcadeera.entity.Publisher;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CheckNullPublisher implements CheckNull<Publisher> {
    @Override
    public void checkForNull(Publisher publisher) {
    }
}
