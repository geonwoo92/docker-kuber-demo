package com.example.demo.article.service;


import com.example.demo.article.model.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.common.component.MessengerVo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repository;


    @Override
    public MessengerVo save(ArticleDto articleDto) {
        entityToDto(Optional.of(repository.save(dtoToEntity(articleDto))));
        return new MessengerVo();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        repository.deleteById(id);
        return new MessengerVo();
    }

    @Override
    public MessengerVo modify(ArticleDto articleDto) {
        throw new UnsupportedOperationException("Unimplemented method 'updatePassword'");

    }


    @Override
    public List<ArticleDto> findAll() {
        return new ArrayList<>();
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
