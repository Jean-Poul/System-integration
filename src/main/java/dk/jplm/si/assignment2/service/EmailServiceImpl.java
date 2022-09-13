package dk.jplm.si.assignment2.service;

import dk.jplm.si.assignment2.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    CountryServiceImp countryService;
    @Autowired
    GenderServiceImpl genderService;

    @Autowired
    EmailSenderService senderService;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public String sendEmails(String body, MultipartFile file, List<Guest> guests) throws Exception {

        String fileName = fileStorageService.storeFile(file);
        String response = "Invited guests: ";

        try {
            guests = setCountries(guests);
            guests = setTitles(guests);

        } catch (Exception e) {
            throw e;
        }
        for (Guest g : guests
        ) {
            response += senderService.sendEmail(g.getMail(), "Invitation", preapareBody(g, body), "src/main/resources/static/" + fileName) + "\n";
        }
        return response;
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

    private String preapareBody(Guest guest, String body) {
        return "Dear " + guest.getTitle() + " " + guest.getName() + ",\n\n" + body;
    }


}
