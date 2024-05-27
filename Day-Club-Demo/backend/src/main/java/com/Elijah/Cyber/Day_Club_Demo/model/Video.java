package com.Elijah.Cyber.Day_Club_Demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import com.Elijah.Cyber.Day_Club_Demo.model.Comment;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(value = "Video")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    private String id;
    private String title;
    private String description;
    private String userId;
    private Integer likes;
    private Integer dislikes;
    private Set<String> tags;
    private String videoUrl;
    private Videostatus videoStatus;
    private Integer viewCount;
    private String thumbnailURL;
    private List<Comment> commentList;

}
