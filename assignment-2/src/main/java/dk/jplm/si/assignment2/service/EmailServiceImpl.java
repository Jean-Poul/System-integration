package dk.jplm.si.assignment2.service;

import dk.jplm.si.assignment2.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    CountryServiceImp countryService;
    @Autowired
    GenderServiceImpl genderService;

    @Override
    public String sendEmail(String email) throws Exception {
        throw new Exception("Not implemented yet");
    }

    private List<Guest> setCountries(List<Guest> guests) {
        for (Guest g : guests
        ) {
            try {
                g.setCountry(countryService.getCountryByIP(g.getIp_address()));
            } catch (Exception e) {
                g.setCountry("DK");
            }
        }
        return guests;
    }

    private List<Guest> setTitles(List<Guest> guests) throws Exception {
        for (Guest g : guests
        ) {
            g.setTitle(genderService.getTitleByCountryAndName(g.getCountry(), g.getName()));
        }
        return guests;
    }

    public String sendEmails(String body, String fileName, List<Guest> guests) {
        try {
            guests = setCountries(guests);
            guests = setTitles(guests);
        } catch (Exception e) {
            e.printStackTrace();

        }
        String titles = "Titles: ";
        for (Guest g : guests
        ) {
            titles += g.getTitle() + ", ";
        }
        return titles;
    }


}
