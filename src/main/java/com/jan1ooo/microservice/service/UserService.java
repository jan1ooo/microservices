package com.jan1ooo.microservice.service;

import com.jan1ooo.microservice.DTO.UserDTO;
import com.jan1ooo.microservice.DTO.mapper.UserMapper;
import com.jan1ooo.microservice.model.UserModel;
import com.jan1ooo.microservice.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private UserMapper userMapper;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> findAll(){
        log.error("getUsers");
        return repository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO findById(@NotNull @Positive Long id){
        return repository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> {
                log.error("User not found with id {}", id);
                return new RuntimeException("User not found with id" + id);
                });
    }

    public UserDTO create(@Valid @NotNull UserDTO userDTO){
        return userMapper.toDto(repository.save(userMapper.toEntity(userDTO)));
    }

    public UserDTO update(@NotNull @Positive Long id, @Valid @NotNull UserDTO userDTO){
        return repository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(userDTO.name());
                    recordFound.setEmail(userDTO.email());
                    return userMapper.toDto(repository.save(recordFound));
                })
                .orElseThrow(() -> new RuntimeException("Not found User"));
    }

    public void delete(@NotNull @Positive Long id){
        repository.findById(id)
                .map(recordFound -> {
                    repository.deleteById(id);
                    return true;
                })
                .orElseThrow(() -> new RuntimeException("Not found user"));
    }
}
