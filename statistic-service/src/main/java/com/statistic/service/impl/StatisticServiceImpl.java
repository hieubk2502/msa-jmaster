package com.statistic.service.impl;

import com.statistic.domain.Statistic;
import com.statistic.dto.CreateStatisticDTO;
import com.statistic.dto.StatisticResponseDTO;
import com.statistic.mapper.StatisticMapper;
import com.statistic.repository.StatisticRepository;
import com.statistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    StatisticRepository statisticRepository;

    @Autowired
    StatisticMapper statisticMapper;

    @Override
    public void add(CreateStatisticDTO statisticDTO) {
        Statistic statistic = statisticMapper.toStatistic(statisticDTO);

        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticResponseDTO> getAll() {
        return statisticRepository.findAll()
                .stream()
                .map(statisticMapper::toStatisticResponseDTO)
                .collect(Collectors.toUnmodifiableList());
    }
}
