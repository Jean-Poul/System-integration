package dk.jplm.si.assignment2.service;

import dk.jplm.si.assignment2.model.Guest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EmailService {
    String sendEmails(String body, MultipartFile file, List<Guest> guests) throws Exception;
}
