package com.zeero.us.url.shortner.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DefaultApiResponse {
    private String code;
    private String message;
    private Object data;
}
