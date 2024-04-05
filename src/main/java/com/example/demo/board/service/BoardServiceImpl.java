package com.example.demo.board.service;


import com.example.demo.board.model.BoardDto;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;


    @Override
    public BoardDto save(BoardDto boardDto) {
        return entityToDto(Optional.of(repository.save(dtoToEntity(boardDto))) );
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);

    }

    @Override
    public List<BoardDto> findAll(PageRequestVo vo) {
        return null;
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
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
