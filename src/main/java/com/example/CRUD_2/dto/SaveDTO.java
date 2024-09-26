package com.example.CRUD_2.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SaveDTO {

    @Schema(description = "제목", example = "게시판")
    private String title;
    private String content;
}


