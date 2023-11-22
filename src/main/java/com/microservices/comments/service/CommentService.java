package com.microservices.comments.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.comments.model.Comment;
import com.microservices.comments.repository.CommentRepository;

@Service
public class CommentService {
    @Autowired
    CommentRepository repository;

    public List<Comment> findAll(){
        return repository.findAll();
    }

    public Comment findById(String id){
        Optional<Comment> comment = repository.findById(id);

        if(comment.isPresent())
            return comment.get();

        throw new IllegalArgumentException("invalid id");
    }


    public void save(Comment c){
        // https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute
        if(c.getMsg() == null || c.getProject() == null)
            throw new IllegalArgumentException("missing params");


        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(tz);
        c.setPostTime(df.format(new Date()));

        repository.save(c);
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
