package com.smalik.sample;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("cloud")
public class CloudService implements MessageService {
    @Override
    public String getMessage() {
        return "I am the cloud service";
    }
}
