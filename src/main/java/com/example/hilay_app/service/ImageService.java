package com.example.hilay_app.service;

import com.example.hilay_app.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final ImageRepository imageRepository;


    public String storeFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + File.separator + fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/files/download/")
                    .path(fileName)
                    .toUriString();
            return fileDownloadUri;
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }
}
