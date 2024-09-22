package com.zeero.us.url.shortner.service;

import com.zeero.us.url.shortner.dto.DefaultApiResponse;
import org.springframework.http.ResponseEntity;

public interface UrlService {
    ResponseEntity<DefaultApiResponse> shortenUrl(String originalUrl);

    DefaultApiResponse getOriginalUrl(String shortUrl);
}
