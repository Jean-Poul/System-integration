package dk.jplm.si.assignment2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.jplm.si.assignment2.model.GuestEmailList;
import dk.jplm.si.assignment2.service.CountryServiceImp;
import dk.jplm.si.assignment2.service.EmailServiceImpl;
import dk.jplm.si.assignment2.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/emails")
public class EmailResource {
    private static final Logger logger = LoggerFactory.getLogger(EmailResource.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping
    public String sendEmails(@RequestParam("list") String list, @RequestParam("file") MultipartFile file) throws Exception {
        GuestEmailList guestList;
        try {
            guestList = objectMapper.readValue(list, GuestEmailList.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return emailService.sendEmails(guestList.getBody(), file, guestList.getGuests());
    }
}
