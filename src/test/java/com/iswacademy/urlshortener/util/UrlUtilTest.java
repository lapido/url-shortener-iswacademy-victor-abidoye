package com.iswacademy.urlshortener.util;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UrlUtilTest {

    @Test
    public void testHashMd5(){
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";

        assertThat(UrlUtil.hashMd5(password).equals(hash)).isTrue();

    }

    @Test
    public void splitGetBaseUrlTest(){
        System.out.println(UrlUtil.splitGetBaseUrl("localhost://9090/ikik"));
    }

    @Test
    public void generateShortUrlTest(){
        System.out.println(UrlUtil.generateShortUrl("http://google.com",0,6));
    }

    @Test
    public void formShortUrlTest(){
        System.out.println(UrlUtil.formShortUrl("http://localhost:8080", "djdjdj"));
    }
}
