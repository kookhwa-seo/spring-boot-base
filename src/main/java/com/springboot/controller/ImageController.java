package com.springboot.controller;

import com.springboot.domain.Image;
import com.springboot.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    @GetMapping("")
    public ResponseEntity<List<Image>> getImages(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(imageService.getImages(page, size));
    }

    @PostMapping("")
    public ResponseEntity<String> createImage() throws IOException {
        imageService.createImages();
        return ResponseEntity.ok("success!!");
    }
}
