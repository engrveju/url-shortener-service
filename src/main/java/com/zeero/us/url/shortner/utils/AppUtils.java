package com.zeero.us.url.shortner.utils;



import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

public class AppUtils {

    public static String generateUniqueUrl(String url){
        int desiredLength;

        if(url.length()>15){
            desiredLength = 8;
        } else if (url.length()<=3) {
            desiredLength = 2;
        } else{
            desiredLength = url.length()/2;
        }
        return UUID.randomUUID().toString().substring(0, desiredLength);
    }

    public static String getBaseUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .build()
                .toUriString() + "/";
    }

    public static String getFullUrl(String path) {
        return getBaseUrl() + path;
    }


}
