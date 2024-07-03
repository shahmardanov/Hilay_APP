package com.example.hilay_app.service.image;

import com.example.hilay_app.exception.ImageFileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageUpdateService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public ResponseEntity<String> updateFile(String fileName, MultipartFile file) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();


            FileSystemResource existingResource = new FileSystemResource(filePath);
            if (!existingResource.exists() || !existingResource.isReadable()) {
                throw new ImageFileNotFoundException(HttpStatus.NOT_FOUND.name(),"File not found or cannot be read: " + fileName);
            }

            Files.delete(filePath);

            Files.write(filePath, file.getBytes());

            String fileDownloadUri = "/api/files/download/" + fileName;
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("File updated successfully. Download URL: " + fileDownloadUri);

        } catch (IOException e) {
            throw new RuntimeException("Error updating file: " + e.getMessage());
        }
    }

}
