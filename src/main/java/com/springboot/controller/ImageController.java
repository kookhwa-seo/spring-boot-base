package com.springboot.controller;

import com.springboot.domain.Image;
import com.springboot.payload.request.ImageRequest;
import com.springboot.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
@Validated
public class ImageController {
    private final ImageService imageService;

    @GetMapping("")
    public ResponseEntity<List<Image>> getImages(@RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(imageService.getImages(page, size));
    }

    @PostMapping("")
    public ResponseEntity<String> createImages() throws IOException {
        imageService.createImages();
        return ResponseEntity.status(HttpStatus.CREATED).body("success!!");
    }

    @PostMapping("/add")
    public ResponseEntity<Image> createImage(@Valid @RequestBody ImageRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(imageService.createImage(request));
    }
}
