package com.springboot.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.domain.Image;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class ImageResponse {
    private String thumbnail;

    private String title;

    @JsonProperty("originalWidth")
    private int original_width;

    @JsonProperty("originalHeight")
    private int original_height;

    private String dummy;

    public ImageResponse(Image image) {
        BeanUtils.copyProperties(image, this);
    }
}
