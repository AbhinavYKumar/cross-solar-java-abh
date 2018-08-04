package com.crossover.techtrial.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.vo.HourlyElectricityVO;

/**
 * HourlyElectricityService interface for all services realted to HourlyElectricity.
 * @author Crossover
 *
 */
public interface HourlyElectricityService {
  HourlyElectricityVO save(HourlyElectricityVO hourlyElectricity);
  
  List<HourlyElectricityVO> getAllHourlyElectricityByPanelId(Long panelId, Pageable pageable);
  
  public DailyElectricity calculateDailyElectricityGenerated(String panelSerial);
}
