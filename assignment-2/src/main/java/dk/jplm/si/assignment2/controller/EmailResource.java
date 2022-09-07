package dk.jplm.si.assignment2.controller;

import dk.jplm.si.assignment2.model.GuestEmailList;
import dk.jplm.si.assignment2.service.FileStorageServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/email")
public class EmailResource {
    // https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/

    private static final Logger logger = LoggerFactory.getLogger(EmailResource.class);


    @Autowired
    private FileStorageServiceImpl fileStorageService;
    @PostMapping
    public String sendEmails(@RequestBody GuestEmailList list, @RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();


        return "Your body is: " + list.getBody() + " first guest name: " + list.getGuests().get(0).getName();
    }
}
