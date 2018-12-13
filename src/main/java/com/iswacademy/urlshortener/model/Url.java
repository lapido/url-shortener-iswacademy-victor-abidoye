package com.iswacademy.urlshortener.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter @Setter
public class Url implements Serializable {
    private long id;
    private String shortenedUrl, originalUrl;
    private Date created;
}
