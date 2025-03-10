package com.statistic.controller;

import com.statistic.dto.CreateStatisticDTO;
import com.statistic.dto.StatisticResponseDTO;
import com.statistic.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StatisticController {
    @Autowired
    private StatisticService statisticService;

    // Add new
    @PostMapping("/create")
    public CreateStatisticDTO add(@RequestBody CreateStatisticDTO statisticDTO) {
        log.debug("Add statistic");

	try {
	    Thread.sleep(10000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

        statisticService.add(statisticDTO);
        return statisticDTO;
    }

    // get all
    @GetMapping
    public List<StatisticResponseDTO> getAll() {
        return statisticService.getAll();
    }
}