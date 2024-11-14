package com.example.restservice.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewEmailRequest {
    private String fromAddress;
    private String toAddress;
    private String content;
}
