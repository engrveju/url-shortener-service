package com.zeero.us.url.shortner.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UrlShortenerDto {
    @NotBlank
    private String url;
}
