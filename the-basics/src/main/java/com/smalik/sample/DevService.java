package com.smalik.sample;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("default")
public class DevService implements MessageService {
    @Override
    public String getMessage() {
        return "I am the development service";
    }
}
