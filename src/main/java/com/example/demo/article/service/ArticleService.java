package com.example.demo.article.service;

import com.example.demo.article.model.Article;
import com.example.demo.article.model.ArticleDto;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.service.CommandService;
import com.example.demo.common.service.QueryService;
import com.example.demo.user.model.UserDto;

import java.util.Optional;


public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {
    MessengerVo modify(ArticleDto article);
    default Article dtoToEntity(ArticleDto dto) {

        return Article.builder().build();
    }

    default ArticleDto entityToDto(Optional<Article> optional) {

        return ArticleDto.builder().build();

    }
}
