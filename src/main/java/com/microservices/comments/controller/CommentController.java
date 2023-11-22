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
import com.microservices.comments.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getComment(@RequestParam(required = false) Optional<String> id){
        List<Comment> res;
        if(id.isPresent()){
            res = new ArrayList<Comment>();
            res.add(commentService.findById(id.get()));
        } else{
            res = commentService.findAll();
        }

        return new ResponseEntity<List<Comment>>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> postComment(@RequestBody Comment c){
        commentService.save(c);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> patchComment(@RequestParam String id){
        commentService.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
