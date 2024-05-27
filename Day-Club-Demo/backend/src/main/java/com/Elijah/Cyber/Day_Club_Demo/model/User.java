package com.Elijah.Cyber.Day_Club_Demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value="User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String userID;
    private String firstname;
    private String lastname;
    private String fullName;
    private String emailAddr;
    private Set<String> subbedToUsers;
    private Set<String> subs;
    private List<String> videoHistory;
    private Set<String> likedVideos;
    private Set<String> dislikedVideos;

}
