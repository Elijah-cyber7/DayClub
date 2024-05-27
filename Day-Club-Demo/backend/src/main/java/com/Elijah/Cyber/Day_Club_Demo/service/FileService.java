package com.Elijah.Cyber.Day_Club_Demo.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadFile(MultipartFile file);
}
