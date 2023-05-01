package com.example.project;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import spock.lang.Specification;

//singleton

@SpringBootTest
public abstract class AbstractIntegrationContainerBaseTest extends Specification {

    static final GenericContainer MY_REDIS_CONTAINER; // execute only once

    static {
        MY_REDIS_CONTAINER = new GenericContainer<>("redis:6") //redis:6 : docker image name
                .withExposedPorts(6379);

        MY_REDIS_CONTAINER.start();

        System.setProperty("spring.redis.host", MY_REDIS_CONTAINER.getHost());
        System.setProperty("spring.redis.port", MY_REDIS_CONTAINER.getMappedPort(6379).toString());

    }


}
