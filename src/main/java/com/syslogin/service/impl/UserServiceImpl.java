package com.syslogin.service.impl;

import com.syslogin.entity.RoleEntity;
import com.syslogin.entity.UserEntity;
import com.syslogin.repository.RoleRepo;
import com.syslogin.repository.UserRepo;
import com.syslogin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final RoleRepo roleRepo;

    @Override
    public UserEntity addUser(UserEntity user) {
        return userRepo.save(user);
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public void addRoleToUser(String roleName, String userName) {
        RoleEntity role = roleRepo.findByName(roleName);
        UserEntity user = userRepo.findByUserName(userName);
        user.getRoles().add(role);
    }

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepo.findAll();
    }
}
