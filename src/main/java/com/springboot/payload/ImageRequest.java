package com.springboot.payload;

import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
public class ImageRequest {
    @NotEmpty
    private String thumbnail;

    @NotEmpty
    private String title;

    @Min(value = 1)
    private int original_width;

    @Min(value = 1)
    private int original_height;
}
