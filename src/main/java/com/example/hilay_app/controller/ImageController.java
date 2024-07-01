package com.example.hilay_app.controller;

import com.example.hilay_app.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

}
