package com.example.hilay_app.controller;

import com.example.hilay_app.service.image.ImageDeleteService;
import com.example.hilay_app.service.image.ImageReadService;
import com.example.hilay_app.service.image.ImageCreateService;
import com.example.hilay_app.service.image.ImageUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageCreateService imageCreateService;
    private final ImageReadService imageReadService;
    private final ImageUpdateService imageUpdateService;
    private final ImageDeleteService imageDeleteService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileDownloadUri = imageCreateService.storeFile(file);
        return ResponseEntity.ok(fileDownloadUri);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<FileSystemResource> downloadFile(@PathVariable String fileName) {
        return imageReadService.getFile(fileName);
    }

    @PutMapping("/update/{fileName}")
    public ResponseEntity<String> updateFile(@PathVariable String fileName,
                                             @RequestParam("file") MultipartFile file) {
        return imageUpdateService.updateFile(fileName, file);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
       return imageDeleteService.deleteFile(fileName);
    }
}
