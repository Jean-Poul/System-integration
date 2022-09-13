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

    @Autowired
    EmailSenderService senderService;

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

        // TODO this need implementation with email smtp

        try {
            guests = setCountries(guests);
            guests = setTitles(guests);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Guest g : guests
        ) {
         //   senderService.sendEmail(g.getMail(), "Invitation",preapareBody(g,body),fileName);
        }



    //    senderService.sendSimpleEmail("cph-mw216@cphbusiness.dk", "Simple Test", "blah blah blah blah");
        // The code below is just some test code
        String titles = "Titles: ";

        for (Guest g : guests
        ) {
            titles += g.getTitle() + ", ";
        }
        return titles;
    }

    private String preapareBody(Guest guest, String body) {
        return "Dear " + guest.getTitle() + " " + guest.getName() + "\n" + body;
    }


}
