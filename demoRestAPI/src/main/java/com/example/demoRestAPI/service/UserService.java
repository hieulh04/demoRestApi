package com.example.demoRestAPI.service;

import com.example.demoRestAPI.model.Users;
import com.example.demoRestAPI.repo.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAll(){
        return userRepository.findAll();
    }

     public Users add(Users users){
        users.setCreateTime(new Date());
        return userRepository.save(users);
     }

    public Users getOne(Integer id){
        Optional<Users> optional = userRepository.findById(id);
        return optional.isPresent() ? optional.get() :null;
    }

    public Users update(Integer id, Users users){
        Optional<Users> optional = this.userRepository.findById(id);
        return optional.map(o->{
            o.setName(users.getName());
            o.setBirthday(users.getBirthday());
            o.setGender(users.getGender());
            o.setStatus(users.getStatus());
            o.setUpdateTime(new Date());
            return userRepository.save(o);
        }).orElse(null);
    }
    public Users delete(Integer id) {
        Optional<Users> optional = userRepository.findById(id);
        return optional.map(o -> {
            userRepository.delete(o);
            return o;
        }).orElse(null);
    }

}
