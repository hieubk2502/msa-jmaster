package com.dev.account.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {

    private String from;
    private String to;
    private String toName;
    private String subject;
    private String content;

}
