package com.Elijah.Cyber.Day_Club_Demo.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService{

    public static final String BUCKETNAME = "dayclubdemostorage";
    private final AmazonS3Client awsS3Client;

    @Override
    public String uploadFile(MultipartFile file)  {
        // Logic to upload the file to AWS S3

        // Prepare a Key
        var filenameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        var key = UUID.randomUUID().toString() + filenameExtension; // Generating random unique key for the aws bucket

        var metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            awsS3Client.putObject(BUCKETNAME, key, file.getInputStream(), metadata);          // uploading to the bucket
        } catch (IOException ioException){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An exception occured while uploading the file");
        }
        awsS3Client.setObjectAcl(BUCKETNAME, key, CannedAccessControlList.PublicRead);

        return awsS3Client.getResourceUrl(BUCKETNAME,key);

    }
}
