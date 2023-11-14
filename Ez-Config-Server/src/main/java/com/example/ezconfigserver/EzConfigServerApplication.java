package com.example.ezconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EzConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzConfigServerApplication.class, args);
    }

}
