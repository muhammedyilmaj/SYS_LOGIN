package com.syslogin.service.impl;

import com.syslogin.entity.RoleEntity;
import com.syslogin.repository.RoleRepo;
import com.syslogin.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;
    @Override
    public RoleEntity addRole(RoleEntity role) {
        return roleRepo.save(role);
    }

    @Override
    public RoleEntity getRoleByName(String name) {
        return roleRepo.findByName(name);
    }

    @Override
    public List<RoleEntity> getRoles() {
        return (List<RoleEntity>) roleRepo.findAll();
    }
}
