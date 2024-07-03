package com.example.hilay_app.service.image;

import com.example.hilay_app.entity.Image;
import com.example.hilay_app.exception.ImageFileNotFoundException;
import com.example.hilay_app.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ImageDeleteService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final ImageRepository imageRepository;

    public ImageDeleteService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public ResponseEntity<String> deleteFile(String fileName) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(fileName).normalize();
            FileSystemResource resource = new FileSystemResource(filePath);

            if (resource.exists() && resource.isReadable()) {
                Files.delete(filePath);
                Optional<Image> optionalImage = imageRepository.findByFileName(fileName);
                if (optionalImage.isPresent()) {
                    Image image = optionalImage.get();
                    imageRepository.delete(image);
                }
                return ResponseEntity.ok().body("File deleted successfully: " + fileName);
            } else {
                throw new ImageFileNotFoundException(HttpStatus.NOT_FOUND.name(), "File not found or cannot be deleted: " + fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error deleting file: " + fileName + ". " + e.getMessage());
        }
    }
}
