package com.statistic.service;

import com.statistic.dto.CreateStatisticDTO;
import com.statistic.dto.StatisticResponseDTO;

import java.util.List;

public interface StatisticService {

    void add(CreateStatisticDTO statisticDTO);

    List<StatisticResponseDTO> getAll();
}
