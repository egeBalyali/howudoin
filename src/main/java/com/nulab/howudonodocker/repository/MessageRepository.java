package com.nulab.howudonodocker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nulab.howudonodocker.model.Message;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    @Query("{ '$or': [ {'senderId': ?0, 'receiverId': ?1}, {'senderId': ?1, 'receiverId': ?0} ] }")
    List<Message> findByParticipants(String userId1, String userId2);
}
