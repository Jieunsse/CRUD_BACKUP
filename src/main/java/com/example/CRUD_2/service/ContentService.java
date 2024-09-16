package com.example.CRUD_2.service;

import com.example.CRUD_2.Entity.ContentEntity;
import com.example.CRUD_2.dto.SaveDTO;
import com.example.CRUD_2.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentService {


    private ContentRepository contentRepository;

    @Autowired
    public ContentService(ContentRepository contentRepository){

        this.contentRepository = contentRepository;
    }

    public void saveContent(SaveDTO saveDTO) {

        String title = saveDTO.getTitle();
        String content = saveDTO.getContent();

        ContentEntity content1 = new ContentEntity();

        // 보통 생성자를 통해 생성.
        content1.setTitle(title);
        content1.setContent(content);


        contentRepository.save(content1);

        return;
    }
}
