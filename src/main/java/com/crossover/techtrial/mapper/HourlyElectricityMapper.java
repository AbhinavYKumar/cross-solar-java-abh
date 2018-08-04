package com.crossover.techtrial.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.vo.HourlyElectricityVO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel="spring")
public interface HourlyElectricityMapper {
	public HourlyElectricityVO fromDB(HourlyElectricity HourlyElectricity);
	public HourlyElectricity toDB(HourlyElectricityVO hourlyElectricityVO);
}
