package com.statistic.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CreateStatisticDTO {

    private String message;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdDate;
}
