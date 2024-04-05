package com.example.demo.common.service;
//값 변경
public interface CommandService<T> {

    T save(T t);
    void deleteById(Long id);
}
