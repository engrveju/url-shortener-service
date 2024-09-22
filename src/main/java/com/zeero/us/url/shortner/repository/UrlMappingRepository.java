package com.zeero.us.url.shortner.repository;

import com.zeero.us.url.shortner.entities.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

    @Query("SELECT u.originalUrl FROM UrlMapping u WHERE u.shortUrl=:shortUrl")
    Optional<String> findByShortUrl(@Param("shortUrl") String shortUrl);

    @Query("SELECT COUNT(u) > 0 FROM UrlMapping u WHERE u.shortUrl = :shortUrl")
    boolean existsByShortUrl(@Param("shortUrl") String shortUrl);

}

