package com.iswacademy.urlshortener.dao;

import com.iswacademy.urlshortener.model.Url;

public interface UrlDao {
    public Url create(Url url);

    public String getUrl(String key);
}
