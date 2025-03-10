package com.dev.account.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Data
public class CreateStatisticDTO {

    private String message;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdDate;

}
