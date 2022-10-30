package com.syslogin.service;

import com.syslogin.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity addUser(UserEntity user);
    UserEntity getUserByUserName(String userName);
    void addRoleToUser (String roleName, String userName);
    List<UserEntity> getUsers();

}
