package com.crossover.techtrial.vo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
public class PanelVOTest{
	@Test
	public void testSetId() {
		PanelVO panelVO= new PanelVO();
		panelVO.setId(100L);
		assertTrue(panelVO.getId() == 100L);
	  }
	  @Test
	  public void testSetSerial() {
		  PanelVO panelVO= new PanelVO();
		  panelVO.setSerial("1234567890123456");
		  assertTrue(panelVO.getSerial() == "1234567890123456");
	  }
	  @Test
	  public void testWrongSerial() {
		  PanelVO panelVO= new PanelVO();
		  panelVO.setSerial("1234567890123465445656");
		  
	  }
	  @Test
	  public void testSetLongitude() {
		  PanelVO panelVO= new PanelVO();
		  panelVO.setLongitude(12.1234567);
		  assertTrue(panelVO.getLongitude() == 12.1234567);
	  }
	  @Test
	  public void testSetLatitude() {
		  PanelVO panelVO= new PanelVO();
		  panelVO.setLatitude(12.1234567);
		  assertTrue(panelVO.getLatitude() == 12.1234567);
	  }
	  @Test
	  public void setBrand() {
		  PanelVO panelVO= new PanelVO();
		  panelVO.setBrand("tesla");
		  assertTrue(panelVO.getBrand() == "tesla");
	  }

}
