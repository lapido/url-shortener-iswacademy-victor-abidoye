package com.iswacademy.urlshortener.controller;

import com.iswacademy.urlshortener.controller.model.UrlRequest;
import com.iswacademy.urlshortener.controller.model.UrlResponse;
import com.iswacademy.urlshortener.exception.RequestException;
import com.iswacademy.urlshortener.model.Url;
import com.iswacademy.urlshortener.service.UrlShortenerService;
import com.iswacademy.urlshortener.util.UrlUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/")
public class UrlController {

    private final UrlShortenerService urlShortenerService;
    public UrlController(UrlShortenerService urlShortenerService){
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("url")
    public UrlResponse shortenUrl(@Validated @RequestBody UrlRequest urlRequest, HttpServletRequest request){
        UrlResponse urlResponse = null;

        if (UrlUtil.validateUrl(urlRequest.getLongUrl())){
            Url url = new Url();
            url.setOriginalUrl(urlRequest.getLongUrl());
            Url shtUrl = urlShortenerService.saveUrl(url);
            String shortenedUrl = shtUrl.getShortenedUrl();

            String urlShort = UrlUtil.formShortUrl(request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()), shortenedUrl);

            urlResponse = new UrlResponse("201", "Successfully Created",
                    url.getOriginalUrl(), urlShort);

            return urlResponse;
        }

        throw new RequestException("Please enter a valid Url");
    }

    @RequestMapping(value = "url", method = RequestMethod.GET)
    public UrlResponse getLongUrl(@RequestParam("shtUrl") String shtUrl, HttpServletRequest request){

        UrlResponse urlResponse = null;
        String requestUrl = UrlUtil.splitGetBaseUrl(shtUrl);

        Url url = new Url();

        String longUrl = urlShortenerService.getUrl(requestUrl);
        url.setOriginalUrl(longUrl);
        url.setShortenedUrl(requestUrl);

        String urlShort = UrlUtil.formShortUrl(request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath()), url.getShortenedUrl());

        urlResponse = new UrlResponse("200", "Found",
                url.getOriginalUrl(), urlShort);

        return urlResponse;

    }



}
