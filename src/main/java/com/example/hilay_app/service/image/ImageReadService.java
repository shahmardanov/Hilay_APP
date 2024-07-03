package com.example.hilay_app.service.image;

import com.example.hilay_app.exception.ImageFileNotFoundException;
import com.example.hilay_app.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class ImageReadService {

    @Value("${file.upload-dir}")
    private String uploadDir;
    private final ImageRepository imageRepository;
    public ResponseEntity<FileSystemResource> getFile( String fileName) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
            FileSystemResource resource = new FileSystemResource(filePath);

            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(Files.probeContentType(filePath)))
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                        .body(resource);
            } else {
                throw new ImageFileNotFoundException(HttpStatus.NOT_FOUND.name(),"Could not read the file. " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error determining file type or reading file: " + e.getMessage());
        }
    }

}
