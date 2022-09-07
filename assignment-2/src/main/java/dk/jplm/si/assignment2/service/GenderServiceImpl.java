package dk.jplm.si.assignment2.service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class GenderServiceImpl implements GenderService {
    @Override
    public String getGenderByName(String countryId, String name) throws Exception {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        // need iP here - REWORK - LOOK AT DORAS CLIENT (DNS LOOKUP CANBRUGES SOM LOOKUP
        // WWW.WHATISMYIP.COM/DNS-LOOKUP
        // MAKE AN ENTITY
        String resourceURL = "https://api.genderize.io?name=" + name + "&country_id=" + countryId;
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response);
        } else {
            System.out.println("ERROR");
        }

        throw new Exception("not implemented yet");
    }
}
