package com.example.hilay_app.service.image;

import com.example.hilay_app.entity.Image;
import com.example.hilay_app.exception.ImageFileNameExistsException;
import com.example.hilay_app.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
public class ImageCreateService {

    @Value("${file.upload-dir}")
    private String uploadDir;
    private final ImageRepository imageRepository;



    public String storeFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + File.separator + fileName);
            if (imageRepository.findByFileName(fileName).isPresent()) {
                throw new ImageFileNameExistsException(HttpStatus.CONFLICT.name(), "File with name " + fileName + " already exists,please change name of file");
            }

            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/images/download/")
                    .path(fileName)
                    .toUriString();

            Image image = new Image();
            image.setFileName(fileName);
            image.setFilePath(fileDownloadUri);
            imageRepository.save(image);

            return fileDownloadUri;
        } catch (IOException e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }





}
