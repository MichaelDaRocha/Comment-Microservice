package com.microservices.comments.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.comments.model.Comment;
import com.microservices.comments.repository.CommentRepository;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentRepository mongo;

    @GetMapping
    public ResponseEntity<List<Comment>> getComment(@RequestParam(required = false) Optional<String> id){
        try{
            List<Comment> res;

            if(id.isPresent()){
                res = new ArrayList<Comment>();
                res.add(mongo.findById(id.get()).get());
            } else{
                res = mongo.findAll();
            }
            
            return new ResponseEntity<List<Comment>>(res, HttpStatus.OK);
        
        } catch(Exception err){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<HttpStatus> postComment(@RequestBody Comment c){
        try{
            mongo.save(c);
        } catch(Exception err){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> patchComment(@RequestParam String id){
        try{
            mongo.deleteById(id);
        } catch(Exception err){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
