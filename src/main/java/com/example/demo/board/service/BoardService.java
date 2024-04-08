package com.example.demo.board.service;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.service.CommandService;
import com.example.demo.common.service.QueryService;
import com.example.demo.user.model.UserDto;

import java.util.*;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {
    MessengerVo modify(BoardDto board);

    default Board dtoToEntity(BoardDto dto) {

        return Board.builder().build();
    }

    default BoardDto entityToDto(Optional<Board> optional) {

        return BoardDto.builder().build();

    }
    
}
