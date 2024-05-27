package com.Elijah.Cyber.Day_Club_Demo.repository;

import com.Elijah.Cyber.Day_Club_Demo.model.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepo extends MongoRepository<Video, String> {
}
