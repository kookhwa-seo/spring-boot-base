package com.springboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Image {
    @Id
    @GeneratedValue
    @Column(name = "position", updatable = false, nullable = false)
    private Integer position;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "related_content_id")
    private String related_content_id;

    @Column(name = "serpapi_related_content_link")
    private String serpapi_related_content_link;

    @Column(name = "source")
    private String source;

    @Column(name = "source_logo")
    private String source_logo;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "tag")
    private String tag;

    @Column(name = "original", columnDefinition = "TEXT")
    private String original;

    @Column(name = "original_width")
    private int original_width;

    @Column(name = "original_height")
    private int original_height;

    @Column(name = "is_product")
    private Boolean is_product;

    @Column(name = "created_dt")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    public Timestamp createdDt;

    @Column(name = "updated_dt")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    public Timestamp updatedDt;

    @Builder
    public Image(Integer position, String thumbnail, String related_content_id, String serpapi_related_content_link, String source, String source_logo, String title, String link, String tag, String original, int original_width, int original_height, Boolean is_product, Timestamp createdDt, Timestamp updatedDt) {
        this.position = position;
        this.thumbnail = thumbnail;
        this.related_content_id = related_content_id;
        this.serpapi_related_content_link = serpapi_related_content_link;
        this.source = source;
        this.source_logo = source_logo;
        this.title = title;
        this.link = link;
        this.tag = tag;
        this.original = original;
        this.original_width = original_width;
        this.original_height = original_height;
        this.is_product = is_product;
        this.createdDt = createdDt;
        this.updatedDt = updatedDt;
    }
}
