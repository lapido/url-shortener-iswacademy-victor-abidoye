package com.iswacademy.urlshortener.util;

import org.springframework.util.DigestUtils;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface UrlUtil {

    String URL_REGEX = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";

    Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    static boolean validateUrl(String url){
        Matcher m = URL_PATTERN.matcher(url);
        return m.matches();
    }

    static String generateShortUrl(String longUrl, int startIndex, int endIndex){
        String hash = Base64.getEncoder().encodeToString(hashMd5(longUrl).getBytes())
                .replace('/', '_')
                .replace('+', '-')
                .replace('=', '_');
        return hash.substring(startIndex, endIndex);
    }

    static String splitGetBaseUrl(String shrtUrl){
        return shrtUrl.split("/")[3];
    }

    static String hashMd5(String longUrl) {
        return DigestUtils.md5DigestAsHex(longUrl.getBytes()).toUpperCase();
    }

    static String formShortUrl(String baseUrl, String shtUrl){
        return String.format("%s/%s", baseUrl,shtUrl);
    }
}
