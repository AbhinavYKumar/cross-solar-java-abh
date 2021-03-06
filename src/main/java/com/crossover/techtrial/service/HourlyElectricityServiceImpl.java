package com.crossover.techtrial.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.mapper.HourlyElectricityMapper;
import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.repository.HourlyElectricityRepository;
import com.crossover.techtrial.vo.HourlyElectricityVO;

/**
 * HourlyElectricityServiceImpl will handle electricity generated by a Panel.
 *
 * @author Crossover
 *
 */

@Service
public class HourlyElectricityServiceImpl implements HourlyElectricityService {
  @Autowired
  HourlyElectricityRepository hourlyElectricityRepository;
  @Autowired
  HourlyElectricityMapper hourlyElectricityMapper;
  
  public HourlyElectricityVO save(HourlyElectricityVO hourlyElectricityVO) {
	HourlyElectricity hourlyElectricity =hourlyElectricityMapper.toDB(hourlyElectricityVO);
	HourlyElectricityVO electricityVO = hourlyElectricityMapper.fromDB(hourlyElectricityRepository.save(hourlyElectricity));
    return electricityVO;
  }
  
  public List<HourlyElectricityVO> getAllHourlyElectricityByPanelId(Long panelId, Pageable pageable) {
	  List<HourlyElectricity> hourlyList = hourlyElectricityRepository.findAllByPanelIdOrderByReadingAtDesc(panelId, pageable).getContent();
	  List<HourlyElectricityVO> electricityVOs = new ArrayList<HourlyElectricityVO>();
	  for(HourlyElectricity hElectricity : hourlyList){
		  HourlyElectricityVO electricityVO = hourlyElectricityMapper.fromDB(hElectricity);
		  electricityVOs.add(electricityVO);
	  }
    return electricityVOs;
  }
  public DailyElectricity calculateDailyElectricityGenerated(String panelSerial){
	  LocalDateTime today =new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	  List<HourlyElectricity> dayData = hourlyElectricityRepository.findAllByDateAndSerial(today, panelSerial);
	  DailyElectricity dailyElectricity = new DailyElectricity();
	  if(!CollectionUtils.isEmpty(dayData)){
	  Long sum = dayData.size()>1 ? dayData.stream().filter(o -> o.getGeneratedElectricity() > 10).mapToLong(HourlyElectricity::getGeneratedElectricity).sum() : dayData.get(0).getGeneratedElectricity();
	  dailyElectricity.setSum(sum);
	  Double average = dayData.size()>1 ? (dayData.stream().filter(o -> o.getGeneratedElectricity() > 10).mapToLong(HourlyElectricity::getGeneratedElectricity).average()).getAsDouble() : dayData.get(0).getGeneratedElectricity();
	  dailyElectricity.setAverage(average);
	  Long min = dayData.size()>1 ? (Collections.min(dayData, Comparator.comparing(s -> s.getGeneratedElectricity()))).getGeneratedElectricity() : 0;
	  dailyElectricity.setMin(min);
	  Long max = dayData.size()>1 ? (Collections.max(dayData, Comparator.comparing(s -> s.getGeneratedElectricity()))).getGeneratedElectricity() : dayData.get(0).getGeneratedElectricity();
	  dailyElectricity.setMax(max);
	  }
	  return dailyElectricity;
  }
 
}