package com.example.demoRestAPI.repo;

import com.example.demoRestAPI.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
}
