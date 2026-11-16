package com.back.Felipe.repository;

import com.back.Felipe.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User , String> {

    User findByEmail(String email);


}
