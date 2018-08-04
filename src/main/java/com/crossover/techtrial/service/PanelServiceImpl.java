package com.crossover.techtrial.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.techtrial.mapper.PanelMapper;
import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.repository.PanelRepository;
import com.crossover.techtrial.vo.PanelVO;


/**
 * PanelServiceImpl for panel related handling.
 * @author Crossover
 *
 */
@Service
public class PanelServiceImpl implements PanelService {

  @Autowired
  PanelRepository panelRepository;
  
  @Autowired
  PanelMapper panelMapper;
  
  public PanelServiceImpl(){
	  panelMapper  = Mappers.getMapper(PanelMapper.class);
  }
  
  @Override
  public void register(PanelVO panelVO) { 
	Panel panel = panelMapper.toDB(panelVO);
	panelMapper.fromDB(panel);
    panelRepository.save(panel);
  }
  
  public Panel findBySerial(String serial) {
    return panelRepository.findBySerial(serial);
  }
}
