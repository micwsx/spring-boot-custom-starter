package com.micwsx.greeter.autoconfigure;

import com.micwsx.shared.library.Greeter;
import com.micwsx.shared.library.GreeterConfigParams;
import com.micwsx.shared.library.GreetingConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

/**
 * @ author: Michael
 * @ date: 2023/3/18 10:42
 */
@Configuration
@ConditionalOnClass({Greeter.class})
@EnableConfigurationProperties(GreeterProperties.class)
public class GreeterAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(GreeterAutoConfiguration.class);

    @Autowired
    private GreeterProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
    public GreetingConfig greetingConfig(){
        String name = Optional.ofNullable(greeterProperties.getName()).orElse("Unknown");
        String morningMessage = Optional.ofNullable(greeterProperties.getMorningMessage()).orElse("Good morning!");
        String afternoonMessage = Optional.ofNullable(greeterProperties.getAfternoonMessage()).orElse("Good afternoon!");
        String eveningMessage = Optional.ofNullable(greeterProperties.getEveningMessage()).orElse("Good evening!");
        String nightMessage = Optional.ofNullable(greeterProperties.getNightMessage()).orElse("Good night!");
        GreetingConfig greetingConfig=new GreetingConfig();
        greetingConfig.put(GreeterConfigParams.USER_NAME,name);
        greetingConfig.put(GreeterConfigParams.MORNING_MESSAGE,morningMessage);
        greetingConfig.put(GreeterConfigParams.AFTERNOON_MESSAGE,afternoonMessage);
        greetingConfig.put(GreeterConfigParams.EVENING_MESSAGE,eveningMessage);
        greetingConfig.put(GreeterConfigParams.NIGHT_MESSAGE,nightMessage);
        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreetingConfig greetingConfig) {
        return new Greeter(greetingConfig);
    }


}
