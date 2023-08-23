package com.example.demoRestAPI.api;

import com.example.demoRestAPI.model.Users;
import com.example.demoRestAPI.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserApi {
    @Autowired
    private UserService userService;


    @GetMapping("/api")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getOne(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Users users){
        return ResponseEntity.ok(userService.add(users));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Users users,@PathVariable Integer id){
        return ResponseEntity.ok(userService.update(id,users));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ResponseEntity.ok(userService.delete(id));
    }

}
