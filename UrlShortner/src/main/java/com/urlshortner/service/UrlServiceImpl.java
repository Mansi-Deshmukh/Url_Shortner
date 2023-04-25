package com.urlshortner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urlshortner.entity.Url;
import com.urlshortner.exception.UrlNotFound;
import com.urlshortner.repository.UrlRepo;

@Service
public class UrlServiceImpl implements UrlService
{


    @Autowired
    private UrlRepo urlRepo;

    @Override
    public String shortenUrl(String longUrl) {
       String shortUrl = generateShortUrl();
       Url url = new Url();
       url.setLongUrl(longUrl);
       url.setShortUrl(shortUrl);
       urlRepo.save(url);

        return shortUrl;
    }

    @Override
    public String generateShortUrl() {

        String alp = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<6; i++){
            int idx = (int)(Math.random()*alp.length());
            sb.append(alp.charAt(idx));
        }
        return sb.toString();
    }

    @Override
    public String getLongUrl(String shortUrl) throws UrlNotFound {
        Url url = urlRepo.findByShortUrl(shortUrl);//.orElseThrow(() -> new UrlNotFound("Short url not found.."));
        if(url == null ){
              throw new UrlNotFound("Short url not found..");
        }
        return url.getLongUrl();   
    }
    
}
