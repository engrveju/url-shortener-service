package com.zeero.us.url.shortner.controller;

import com.zeero.us.url.shortner.dto.DefaultApiResponse;
import com.zeero.us.url.shortner.dto.UrlShortenerDto;
import com.zeero.us.url.shortner.service.UrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<DefaultApiResponse> shortenUrl(@RequestBody @Valid UrlShortenerDto urlShortenerDto) {

        return urlService.shortenUrl(urlShortenerDto.getUrl().strip());
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginal(@PathVariable String shortUrl) {
        DefaultApiResponse response = urlService.getOriginalUrl(shortUrl.strip());
        if(response.getData() != null) {
            URI locationUri = URI.create(response.getData().toString());
            ResponseEntity<Void> responseEntity = ResponseEntity.status(HttpStatus.FOUND)
                    .location(locationUri)
                    .build();
            return responseEntity;
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
