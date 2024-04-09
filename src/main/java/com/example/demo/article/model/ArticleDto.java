package com.example.demo.article.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component //
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Log4j2
public class ArticleDto {
    private Long id;
    private String title;
    private String content;
    private Long writer;
    private Long boardId;
    private String regDate;
    private String modDate;

}