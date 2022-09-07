package dk.jplm.si.assignment2.service;

import dk.jplm.si.assignment2.model.GenderizeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenderServiceImpl implements GenderService {
    @Override
    public String getTitleByCountryAndName(String countryId, String name) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        String resourceURL = "https://api.genderize.io?name=" + name + "&country_id=" + countryId;
        ResponseEntity<GenderizeResponse> response = restTemplate.getForEntity(resourceURL, GenderizeResponse.class);

        if (response.getStatusCode() == HttpStatus.OK) {

            return getTitleByGender(response.getBody().getGender());

        } else {
            throw new Exception("Response status is: " + response.getStatusCode().getReasonPhrase());
        }

    }

    private String getTitleByGender(String gender) throws Exception {
        if (gender == null) {
            return "";
        } else if (gender.equals("male")) {
            return "Mr.";
        } else if (gender.equals("female")) {
            return ("Ms.");
        } else {
            return "";
        }
    }
}
