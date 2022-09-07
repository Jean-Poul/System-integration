package dk.jplm.si.assignment2;

import dk.jplm.si.assignment2.property.FileStorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Assignment2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Assignment2Application.class, args);

        soapCall();
        restCall();


    }

    public static void restCall() {
        // rest what are we returning if any?

    }

    public static void soapCall() {
        // soap what are we returning if any?

    }

    @Override
    public void run(String... args) throws Exception {
/*        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // need iP here - REWORK - LOOK AT DORAS CLIENT (DNS LOOKUP CANBRUGES SOM LOOKUP
        // WWW.WHATISMYIP.COM/DNS-LOOKUP
        // MAKE AN ENTITY
        String resourceURL = "https://api.genderize.io?name=peter&country_id=US";
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response);
        } else {
            System.out.println("ERROR");
        }*/
    }


}
