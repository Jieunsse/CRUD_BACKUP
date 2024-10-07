package com.example.CRUD_2.controller;

import com.example.CRUD_2.dto.SaveDTO;
import com.example.CRUD_2.service.ContentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@Tag(name = "게시판", description = "CRUD 서비스의 게시판 기능에 대해 사용되는 API 명세")
@RestController
public class SaveController {


    private ContentService contentService;


    @Autowired
    public SaveController(ContentService contentService) {
        this.contentService = contentService;
    }


    // 스웨거 코드
    @Operation(summary = "게시글 작성", description = "사용자가 작성한 글에 대해 POST 요청 이행")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "작성 성공",
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = "{ \"title\": \"글 제목\",  \"content\": \"글 내용\"}"
                    )
            )),
            @ApiResponse(responseCode = "400", description = "작성 실패",
                    content = @Content(
                            mediaType = "application/json",
                            examples =@ExampleObject(
                                    value = "{ \"error\": \"작성 실패\"}"
                            )
                    ))
    })


    @PostMapping("/save")
    public ResponseEntity<?> saveLogic(SaveDTO saveDTO) {


        contentService.saveContent(saveDTO);



        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}




