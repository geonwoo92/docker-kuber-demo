package com.example.demo.article.service;


import com.example.demo.article.model.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.common.component.PageRequestVo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;


    @Override
    public ArticleDto save(ArticleDto articleDto) {
        return entityToDto(Optional.of(repository.save(dtoToEntity(articleDto))) );
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<ArticleDto> findAll(PageRequestVo vo) {
        return null;
    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
        return Optional.of(entityToDto(repository.findById(id)));
    }

    @Override
    public Long count() {
        return repository.count();
    }


    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
