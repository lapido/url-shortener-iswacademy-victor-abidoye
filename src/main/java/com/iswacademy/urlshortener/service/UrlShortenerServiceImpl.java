package com.iswacademy.urlshortener.service;

import com.iswacademy.urlshortener.dao.UrlDao;
import com.iswacademy.urlshortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    @Autowired
    UrlDao urlDao;


    @Override
    public Url saveUrl(Url url) {
        return urlDao.create(url);
    }

    @Override
    public String getUrl(String key) {
        return urlDao.getUrl(key);
    }
}
