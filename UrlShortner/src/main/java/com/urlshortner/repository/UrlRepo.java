package com.urlshortner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.urlshortner.entity.Url;

@Repository
public interface UrlRepo extends JpaRepository<Url, Long> {
    Url findByShortUrl(String shortUrl);
}
