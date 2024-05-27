package com.Elijah.Cyber.Day_Club_Demo.service;


import com.Elijah.Cyber.Day_Club_Demo.model.Video;
import com.Elijah.Cyber.Day_Club_Demo.repository.VideoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepo videoRepository;
    public void uploadVideo(MultipartFile multipartFile){
        // Upload the file to AWS S3
        // Save the metadata to our Database
        String videoUrl = s3Service.uploadFile(multipartFile);
        var video = new Video();
        video.setVideoUrl(videoUrl);
        videoRepository.save(video);
    }
}
