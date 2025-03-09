package com.statistic.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class StatisticResponseDTO {

    private Long id;

    private String message;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date createdDate;

}
