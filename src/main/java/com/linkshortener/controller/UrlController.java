package com.linkshortener.controller;

import com.linkshortener.service.UrlService;
import com.linkshortener.utils.UrlUtils;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping
public class UrlController {

    private UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping(path = "/")
    public ResponseEntity head() {
        //to do
        return new ResponseEntity("this URL with GET-requests is not supported. Use POST-requests, please", HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity createShortUrl(String url) {
        if(!UrlUtils.isURL(url)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Hashids hashids = new Hashids("this is my salt", 6);
        String shortUrl = hashids.encode(Math.abs(url.hashCode()));
        urlService.save(shortUrl, url);
        return new ResponseEntity(shortUrl, HttpStatus.OK);
    }

    @GetMapping(path = "/{shortUrl}")
    public ResponseEntity redirectShorter(@PathVariable("shortUrl") String shortUrl) {
        String url = urlService.findByShortUrl(shortUrl);
        if(url == null){
            return new ResponseEntity<>("url is not supported", HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}