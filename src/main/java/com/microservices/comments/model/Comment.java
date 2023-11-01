package com.microservices.comments.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
public class Comment {
    
    @Id
    private String _id;

    private String posterName;
    private String msg;

    private String project;
    private String postTime;

    public Comment(String posterName, String msg, String project, String postTime){
        this.posterName = posterName;
        this.msg = msg; 
        this.project = project;

        if(postTime == null){
            // https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
            df.setTimeZone(tz);
            this.postTime = df.format(new Date());
        } else{
            this.postTime = postTime;
        }
    }

    public String getId(){ return _id; }
    public String getPosterName(){ return posterName; }
    public String getMsg(){ return msg; }
    public String getProject(){ return project; }
    public String getPostTime(){ return postTime; }

    public void setPosterName(String posterName){ this.posterName = posterName; }
    public void setMsg(String msg){ this.msg = msg; }
    public void setProject(String project){ this.project = project; }
    public void setPostTime(String postTime) { this.postTime = postTime; }
}
