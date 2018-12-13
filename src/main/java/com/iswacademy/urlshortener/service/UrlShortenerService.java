package com.iswacademy.urlshortener.service;

import com.iswacademy.urlshortener.model.Url;

public interface UrlShortenerService {
    public Url saveUrl(Url url);
    public String getUrl(String key);
}
