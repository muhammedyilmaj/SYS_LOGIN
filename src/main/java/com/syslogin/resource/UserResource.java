package com.syslogin.resource;

import com.syslogin.dto.RoleUserDto;
import com.syslogin.entity.UserEntity;
import com.syslogin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserResource {

    @Autowired
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> getUsers() {
       return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/user")
    public ResponseEntity<UserEntity> getUserByUserName(String userName) {
        return ResponseEntity.ok().body(userService.getUserByUserName(userName));
    }
    @PostMapping("/users")
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/users").toUriString());
        return ResponseEntity.created(uri).body(userService.addUser(user));
    }
    @PostMapping("/users/role")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleUserDto roleUserDto) {
        userService.addRoleToUser(roleUserDto.getRoleName(), roleUserDto.getUsername());
        return ResponseEntity.ok().build();
    }

}
