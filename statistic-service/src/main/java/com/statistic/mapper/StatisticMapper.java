package com.statistic.mapper;

import com.statistic.domain.Statistic;
import com.statistic.dto.CreateStatisticDTO;
import com.statistic.dto.StatisticResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticMapper {

    Statistic toStatistic(CreateStatisticDTO createStatisticDTO);

    StatisticResponseDTO toStatisticResponseDTO(Statistic statistic);

}
