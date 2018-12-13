package com.iswacademy.urlshortener.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter @Getter
public class UrlRequest {
    @NotBlank(message = "Required")
    private String longUrl;

}
