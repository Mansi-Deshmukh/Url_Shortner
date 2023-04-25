package com.urlshortner.service;

import com.urlshortner.exception.UrlNotFound;

public interface UrlService {
    
    public String shortenUrl(String longUrl);

    public String generateShortUrl();

    public String getLongUrl(String shortUrl) throws UrlNotFound;

}
