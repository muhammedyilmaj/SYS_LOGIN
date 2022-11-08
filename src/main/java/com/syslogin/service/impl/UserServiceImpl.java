package com.syslogin.service.impl;

import com.syslogin.entity.RoleEntity;
import com.syslogin.entity.UserEntity;
import com.syslogin.repository.RoleRepo;
import com.syslogin.repository.UserRepo;
import com.syslogin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final RoleRepo roleRepo;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity addUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public void addRoleToUser(String roleName, String userName) {
        RoleEntity role = roleRepo.findByName(roleName);
        UserEntity user = userRepo.findByUsername(userName);
        user.getRoles().add(role);
    }

    @Override
    public List<UserEntity> getUsers() {
        return (List<UserEntity>) userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(userName);
        if(Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
