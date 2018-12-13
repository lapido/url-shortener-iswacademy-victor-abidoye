package com.iswacademy.urlshortener.controller;

import com.iswacademy.urlshortener.service.UrlShortenerService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class UrlRedirectController {

    private final UrlShortenerService urlShortenerService;

    public UrlRedirectController(UrlShortenerService urlShortenerService){
        this.urlShortenerService = urlShortenerService;
    }

    @RequestMapping(value = "{path:[\\w\\d]{6}}", method = RequestMethod.GET)
    public void redirectUser(@PathVariable("path") String path, HttpServletResponse response) throws IOException {
        String longUrl = urlShortenerService.getUrl(path);
        response.sendRedirect(longUrl);
    }


}
