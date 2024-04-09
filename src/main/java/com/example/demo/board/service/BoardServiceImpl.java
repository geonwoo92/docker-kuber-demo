package com.example.demo.board.service;


import com.example.demo.board.model.BoardDto;
import com.example.demo.board.repository.BoardRepository;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;


    @Override
    public MessengerVo save(BoardDto boardDto) {
        entityToDto((repository.save(dtoToEntity(boardDto))) );
        return new MessengerVo();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        repository.deleteById(id);
        return new MessengerVo();

    }

    @Override
    public MessengerVo modify(BoardDto boardDto) {
        return null;
    }


    @Override
    public List<BoardDto> findAll() {
        return repository.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
//        Optional.of(entityToDto(repository.findById(id)));
        return null;
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
