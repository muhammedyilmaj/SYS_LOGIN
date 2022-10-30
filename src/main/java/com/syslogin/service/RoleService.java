package com.syslogin.service;

import com.syslogin.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    RoleEntity addRole(RoleEntity role);
    RoleEntity getRoleByName (String name);
    List<RoleEntity> getRoles();
}
