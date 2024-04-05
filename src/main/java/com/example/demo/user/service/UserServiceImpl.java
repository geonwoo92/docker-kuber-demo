package com.example.demo.user.service;


import com.example.demo.common.component.PageRequestVo;
import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto save(UserDto userDto) {
        return entityToDto(Optional.of(repository.save(dtoToEntity(userDto))) );
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll(PageRequestVo vo) {
        return null;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
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

