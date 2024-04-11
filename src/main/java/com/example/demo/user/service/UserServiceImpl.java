package com.example.demo.user.service;


import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserDto userDto;


    @Override
    public MessengerVo save(UserDto userDto) {
        entityToDto((repository.save(dtoToEntity(userDto))));
        return new MessengerVo();
    }

    @Override
    public MessengerVo deleteById(Long id) {

        repository.deleteById(id);
        return new MessengerVo();
    }

    @Override
    public MessengerVo modify(UserDto userDto) {
        return repository.findById(userDto.getId())
                .map(user -> {
                    user.setName(userDto.getName());
                    user.setPassword(userDto.getPassword());
                    user.setJob(userDto.getJob());
                    user.setPhone(userDto.getPhone());
                    return repository.save(user);
                })
                .map(user -> MessengerVo.builder().message("변경완료").build())
                .orElseGet(() -> MessengerVo.builder().message("존재하지 않는 ID입니다").build());
    }

    @Override
    public List<UserDto> findAll() {

        return repository.findAll().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return repository.findById(id).stream().map(i -> entityToDto(i)).findAny();
    }

    @Override
    public Long count() {
        return repository.count();
    }

    @Override
    public Boolean existsById(Long id) {
        return repository.existsById(id);
    }


    @Override
    public List<UserDto> findUsersByName(String name) {
        return List.of();
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        throw new UnsupportedOperationException("Unimplemented method 'findUsersByJob'");
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public MessengerVo login(UserDto param) {
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}

