package com.nulab.howudonodocker.repository;

import com.nulab.howudonodocker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
}
