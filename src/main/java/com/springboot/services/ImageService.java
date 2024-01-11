package com.springboot.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.domain.Image;
import com.springboot.payload.request.ImageRequest;
import com.springboot.payload.response.ImageResponse;
import com.springboot.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    private final String IMAGE_URL = "https://serpapi.com/search.json?q=Apple&engine=google_images&ijn=0";

    public List<ImageResponse> getImages(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by("position").ascending());
        List<Image> imageList = imageRepository.findAll(pageable).getContent();

        List<ImageResponse> resultList = new ArrayList<>();
        for(Image image : imageList){
            ImageResponse imageResponse = new ImageResponse(image);
            imageResponse.setDummy("success!!!");
            resultList.add(imageResponse);
        }
        return resultList;
    }

    @Transactional
    public void createImages() throws IOException {
        ResponseEntity<String> response = new RestTemplate().getForEntity(IMAGE_URL, String.class);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(response.getBody(), HashMap.class);

        List<LinkedHashMap> images = (ArrayList)map.get("images_results");
        List<Image> imageList = mapper.convertValue(images, new TypeReference<List<Image>>(){});

        imageRepository.saveAll(imageList);
    }

    @Transactional
    public Image createImage(ImageRequest request){
        Image image = Image.builder()
                           .thumbnail(request.getThumbnail())
                           .title(request.getTitle())
                           .original_width(request.getOriginal_width())
                           .original_height(request.getOriginal_height())
                           .build();

        return imageRepository.save(image);
    }
}
