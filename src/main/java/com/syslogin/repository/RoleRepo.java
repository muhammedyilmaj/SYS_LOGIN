package com.syslogin.repository;

import com.syslogin.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<RoleEntity, Long> {
    RoleEntity findByName(String name);
}
