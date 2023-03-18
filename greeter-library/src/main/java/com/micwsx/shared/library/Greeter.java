package com.micwsx.shared.library;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: Michael
 * @date: 2023/3/18 10:29
 */
public class Greeter {

    private final GreetingConfig greetingConfig;

    public Greeter(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    public String greet(LocalDateTime localDateTime) {
        String name = greetingConfig.getProperty(GreeterConfigParams.USER_NAME);
        int hour = localDateTime.getHour();
        if (hour >= 5 && hour < 12) {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(GreeterConfigParams.MORNING_MESSAGE));
        } else if (hour >= 12 && hour < 17) {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(GreeterConfigParams.MORNING_MESSAGE));
        } else if (hour >= 17 && hour < 20) {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(GreeterConfigParams.MORNING_MESSAGE));
        } else {
            return String.format("Hello %s, %s", name, greetingConfig.getProperty(GreeterConfigParams.MORNING_MESSAGE));
        }
    }

    public String greet(){
        return greet(LocalDateTime.now());
    }
}
