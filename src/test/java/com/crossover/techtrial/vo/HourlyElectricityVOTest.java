package com.crossover.techtrial.vo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class HourlyElectricityVOTest {
	  @Test
	  public void testSetId() {
		  HourlyElectricityVO electricityVO = new HourlyElectricityVO();
		  electricityVO.setId(3214242424L);
		  assertTrue(electricityVO.getId() == 3214242424L);
	  }
	  @Test
	  public void testSetPanel() {
		  PanelVO panelVO= new PanelVO();
		  panelVO.setId(100L);
		  HourlyElectricityVO electricityVO = new HourlyElectricityVO();
		  electricityVO.setId(3214242424L);
		  electricityVO.setPanel(panelVO);
		  assertTrue(electricityVO.getPanel().equals(panelVO));
	  }
	  @Test
	  public void testSetGeneratedElectricity() {
		  HourlyElectricityVO electricityVO = new HourlyElectricityVO();
		  electricityVO.setGeneratedElectricity(435345L);
		  assertTrue(electricityVO.getGeneratedElectricity()==435345L);
	  }
	  @Test
	  public void testSetReadingAt() {
		  HourlyElectricityVO electricityVO = new HourlyElectricityVO();
		  electricityVO.setReadingAt("2018-01-31 09:00:00");
		  assertTrue(electricityVO.getReadingAt().equals("2018-01-31 09:00:00"));
	  }
  
}
