package com.micwsx.greeter.sample;

import com.micwsx.shared.library.Greeter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ author: Michael
 * @ date: 2023/3/18 12:08
 */
@SpringBootApplication
public class GreeterSampleApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(GreeterSampleApplication.class);
    }

    @Autowired
    private Greeter greeter;

    @Override
    public void run(String... args) throws Exception {
        if (greeter != null) {
            String greet = greeter.greet();
            logger.info(greet);
        }
    }
}
