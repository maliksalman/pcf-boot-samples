package com.smalik.sample;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DelayConfiguration {

    private boolean delayEnabled;
    private int delayMillis;
    private  boolean delayRandomized;

    public DelayConfiguration(
            @Value("${delay.enabled}") boolean delayEnabled,
            @Value("${delay.randomized}") boolean delayRandomized,
            @Value("${delay.millis}") int delayMillis) {
        this.delayEnabled = delayEnabled;
        this.delayRandomized = delayRandomized;
        this.delayMillis = delayMillis;
    }

    public boolean isDelayEnabled() {
        return delayEnabled;
    }

    public int getDelayMillis() {
        return delayMillis;
    }

    public boolean isDelayRandomized() {
        return delayRandomized;
    }
}
