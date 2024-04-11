package com.example.demo.article.service;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.service.CommandService;
import com.example.demo.common.service.QueryService;


public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {
    MessengerVo modify(ArticleDto article);

    default Article dtoToEntity(ArticleDto dto) {

        return Article.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }

    default ArticleDto entityToDto(Article article) {

        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .regDate(article.getRegDate().toString())
                .modDate(article.getModDate().toString())
                .build();

    }
}
