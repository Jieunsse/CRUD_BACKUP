package com.example.CRUD_2.controller;


import com.example.CRUD_2.Entity.ContentEntity;
import com.example.CRUD_2.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {

    private final ContentService contentService;

    @Autowired
    public ListController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ContentEntity>> list() {

        List<ContentEntity> contentList = contentService.selectContent();

        if (contentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new ResponseEntity<>(contentList, headers, HttpStatus.OK);
    }

}


/*
* @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<?> listPage() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

*
* */
