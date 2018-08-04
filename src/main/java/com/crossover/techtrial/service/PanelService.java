package com.crossover.techtrial.service;

import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.vo.PanelVO;

/**
 * PanelService interface for Panels.
 * @author Crossover
 *
 */
public interface PanelService {
  
  /**
   * Register a panel for electricity monitoring.
   * @param panel to register with system.
   */
  
  void register(PanelVO panel);
  
  Panel findBySerial(String serial);
}
