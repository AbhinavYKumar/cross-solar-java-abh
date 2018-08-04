package com.crossover.techtrial.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.vo.PanelVO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PanelMapper {
public PanelVO fromDB(Panel panel);

public Panel toDB(PanelVO panelVO);
}
