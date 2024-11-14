package com.example.restservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class SimpleEmail {
    private String fromAddress;
    private String toAddress;
    private String content;
}
