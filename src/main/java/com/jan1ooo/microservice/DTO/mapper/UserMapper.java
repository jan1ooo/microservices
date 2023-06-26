package com.jan1ooo.microservice.DTO.mapper;

import com.jan1ooo.microservice.DTO.UserDTO;
import com.jan1ooo.microservice.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel toEntity(UserDTO userDTO){
        if(userDTO == null){
            return null;
        }

        UserModel user = new UserModel();
        if(userDTO.id_user() != null){
            user.setId_user(user.getId_user());
        }
        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        return user;
    }

    public UserDTO toDto(UserModel userModel){
        if(userModel == null){
            return null;
        }
        return new UserDTO(userModel.getId_user(), userModel.getName(), userModel.getEmail());
    }
}
