package dk.jplm.si.assignment2;

import dk.jplm.si.assignment2.property.FileStorageProperties;
import dk.jplm.si.assignment2.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Assignment2Application {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(Assignment2Application.class, args);
    }
}
