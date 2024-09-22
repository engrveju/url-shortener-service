package com.zeero.us.url.shortner.service.serviceImpl;

import com.zeero.us.url.shortner.dto.DefaultApiResponse;
import com.zeero.us.url.shortner.entities.UrlMapping;
import com.zeero.us.url.shortner.repository.UrlMappingRepository;
import com.zeero.us.url.shortner.service.UrlService;
import com.zeero.us.url.shortner.utils.AppUtils;
import com.zeero.us.url.shortner.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
@Slf4j
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlMappingRepository urlMappingRepository;

    @Override
    public ResponseEntity<DefaultApiResponse> shortenUrl(String originalUrl) {
        originalUrl = originalUrl.strip();

        String shortUrl = AppUtils.generateUniqueUrl(originalUrl);

        while(urlExists(shortUrl)){
            log.info("{} already exists. Regenerating new one", shortUrl);
            shortUrl = AppUtils.generateUniqueUrl(originalUrl);
        }

        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setOriginalUrl(originalUrl);
        urlMapping.setShortUrl(shortUrl);
        urlMapping.setCreatedAt(LocalDateTime.now());
        urlMappingRepository.save(urlMapping);

        String generatedUrl = AppUtils.getFullUrl(shortUrl);

        DefaultApiResponse response = ResponseUtil.successResponse(generatedUrl);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public DefaultApiResponse getOriginalUrl(String shortUrl) {
        String originalUrl = urlMappingRepository.findByShortUrl(shortUrl).orElse(null);
        DefaultApiResponse response;

        if(originalUrl == null){
             response = ResponseUtil.errorResponse(HttpStatus.NOT_FOUND);
            return response;
        }

        if(!originalUrl.startsWith("http")) {
            originalUrl = "http://" + originalUrl;
        }

        response = ResponseUtil.successResponse(HttpStatus.OK,originalUrl);
        return response;
    }

    private boolean urlExists(String shortUrl) {
        return urlMappingRepository.existsByShortUrl(shortUrl);
    }

}

