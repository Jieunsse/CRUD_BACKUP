package com.example.CRUD_2.controller;

import com.example.CRUD_2.dto.SaveDTO;
import com.example.CRUD_2.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class SaveController {


    private ContentService contentService;


    @Autowired
    public SaveController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveLogic(SaveDTO saveDTO) {


        contentService.saveContent(saveDTO);



        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}




