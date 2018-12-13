package com.iswacademy.urlshortener.controller.model;

import lombok.Getter;

import java.util.List;

@Getter
public class UrlResponse extends Response {

    private final String longUrl;
    private final String shortUrl;

    public UrlResponse(String code, String description, List<Error> errors,
                       String longUrl, String shortUrl) {
        super(code, description, errors);
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public UrlResponse(String code, String description,
                       String longUrl, String shortUrl) {
        super(code, description, null);
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }


}
