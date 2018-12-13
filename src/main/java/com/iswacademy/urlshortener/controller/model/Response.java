package com.iswacademy.urlshortener.controller.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter @RequiredArgsConstructor
public class Response {
    private final String code;
    private final String description;
    private final List<Error> errors;
}
