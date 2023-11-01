package com.microservices.comments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.comments.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, String>{
    
}