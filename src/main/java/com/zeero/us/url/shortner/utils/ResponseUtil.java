package com.zeero.us.url.shortner.utils;

import com.zeero.us.url.shortner.dto.DefaultApiResponse;
import org.springframework.http.HttpStatus;

public class ResponseUtil {

    public static DefaultApiResponse successResponse(){
        DefaultApiResponse defaultApiResponse = new DefaultApiResponse();

        defaultApiResponse.setCode(HttpStatus.OK.name());
        defaultApiResponse.setMessage("Request Successful");
        return defaultApiResponse;
    }

    public static DefaultApiResponse successResponse(Object data){
        DefaultApiResponse defaultApiResponse = successResponse();
        defaultApiResponse.setData(data);
        return defaultApiResponse;
    }

    public static DefaultApiResponse successResponse(HttpStatus status, Object data){
        DefaultApiResponse defaultApiResponse = new DefaultApiResponse();
        defaultApiResponse.setCode(status.name());
        defaultApiResponse.setMessage("Request Successful");
        defaultApiResponse.setData(data);
        return defaultApiResponse;
    }


    public static DefaultApiResponse errorResponse(HttpStatus status,String message){
        DefaultApiResponse defaultApiResponse = new DefaultApiResponse();

        defaultApiResponse.setCode(status.name());
        defaultApiResponse.setMessage(message);
        return defaultApiResponse;
    }

    public static DefaultApiResponse errorResponse(HttpStatus status){
        DefaultApiResponse defaultApiResponse = new DefaultApiResponse();

        defaultApiResponse.setCode(status.name());
        defaultApiResponse.setMessage("Request Failed");
        return defaultApiResponse;
    }
}
