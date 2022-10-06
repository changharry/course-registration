package com.changzh.courseregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class CourseRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseRegistrationApplication.class, args);
    }

}
