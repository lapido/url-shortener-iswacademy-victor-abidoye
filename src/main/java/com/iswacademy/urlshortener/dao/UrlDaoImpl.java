package com.iswacademy.urlshortener.dao;

import com.iswacademy.urlshortener.exception.RequestException;
import com.iswacademy.urlshortener.model.Url;
import com.iswacademy.urlshortener.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import java.util.Date;

@Repository
public class UrlDaoImpl implements UrlDao {

    private static final String KEY = "Url";
    private final Jedis jedis;

    private RedisTemplate<String, Object> redisTemplate;
    //private HashOperations hashOperations;

    @Autowired
    public UrlDaoImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
        this.jedis = new Jedis();
    }

    @Override
    public Url create(Url url) {
        String shtUrl = UrlUtil.generateShortUrl(url.getOriginalUrl(), 0, 6);

        url.setShortenedUrl(shtUrl);
        url.setCreated(new Date());
        //hashOperations.put(KEY, url.getId(), url);
        jedis.set(shtUrl, url.getOriginalUrl());
        return url;
    }

    @Override
    public String getUrl(String key) {
        String originalUrl = jedis.get(key);
        //Url url = (Url) hashOperations.get(KEY, key);
        //String originalUrl = url.getOriginalUrl();
        if (originalUrl == null) {
            System.out.println("Not found");
            throw new RequestException("URL - " + key + " does not exist");

        }
        return originalUrl;
    }
}
