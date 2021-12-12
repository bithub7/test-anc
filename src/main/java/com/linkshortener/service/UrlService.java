package com.linkshortener.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlService {

    private Map<String, String> urlMap = new HashMap<>();

    public String save (String shortUrl, String url){
        urlMap.put(shortUrl, url);
        return url;
    }

    public String findByShortUrl(String shortUrl){
        String url = urlMap.get(shortUrl);
        return url;
    }
}
