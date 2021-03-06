package com.crossover.techtrial.controller;

import com.crossover.techtrial.mapper.PanelMapper;
import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.service.PanelService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * PanelControllerTest class will test all APIs in PanelController.java.
 * @author Crossover
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PanelControllerTest {
  
  MockMvc mockMvc;
  
  @Mock
  private PanelController panelController;
  
  @Mock
  private PanelService panelService;
  
  @Autowired
  private TestRestTemplate template;
  
  @Before
  public void setup() throws Exception {
	PanelMapper INSTANCE = Mappers.getMapper(PanelMapper.class);
    mockMvc = MockMvcBuilders.standaloneSetup(panelController).build();
  }
  @Test  
  public void testPanelNotAllowDuplicateSerialNumberForRegisteration() {
    HttpEntity<Object> panel = getHttpEntity(
        "{\"serial\": \"1234567890123456\", \"longitude\": \"54.123232\"," 
            + " \"latitude\": \"54.123232\",\"brand\":\"tesla\" }");
    ResponseEntity<Panel> response = template.postForEntity(
        "/api/register", panel, Panel.class);
    Assert.assertEquals(400,response.getStatusCode().value());
  }
  @Test  
  public void testPanelSerialNumberSizeValidation() {
    HttpEntity<Object> panel = getHttpEntity(
        "{\"serial\": \"232323\", \"longitude\": \"54.123232\"," 
            + " \"latitude\": \"54.123232\",\"brand\":\"tesla\" }");
    ResponseEntity<Panel> response = template.postForEntity(
        "/api/register", panel, Panel.class);
    Assert.assertEquals(400,response.getStatusCode().value());
  }
  
  @Test  
  public void testPanelLatitudeValueFormatValidation() {
    HttpEntity<Object> panel = getHttpEntity(
        "{\"serial\": \"1234567890123456\", \"longitude\": \"54.123232\"," 
            + " \"latitude\": \"54.1232323\",\"brand\":\"tesla\" }");
    ResponseEntity<Panel> response = template.postForEntity(
        "/api/register", panel, Panel.class);
    Assert.assertEquals(400,response.getStatusCode().value());
  }

  @Test  
  public void testPanelLongitudeValueFormatValidation() {
    HttpEntity<Object> panel = getHttpEntity(
        "{\"serial\": \"1234567890123456\", \"longitude\": \"54.1232329\"," 
            + " \"latitude\": \"54.123232\",\"brand\":\"tesla\" }");
    ResponseEntity<Panel> response = template.postForEntity(
        "/api/register", panel, Panel.class);
    Assert.assertEquals(400,response.getStatusCode().value());
  }
  @Test  
  public void testSaveHourlyElectricityWrongSerialNumber() {
	 HttpEntity<Object> hourly = getHttpEntity(
		        "{\"panelId\": \"1\", \"longitude\": \"54.1232329\"," 
		            + " \"latitude\": \"54.123232\",\"brand\":\"tesla\" }");
   
    ResponseEntity<Panel> response = template.postForEntity(
        "/api/panels/123456/hourly", hourly, Panel.class);
    Assert.assertEquals(400,response.getStatusCode().value());
  }
  @Test  
  public void testSaveHourlyElectricityWrongLongitudeNumber() {
	 HttpEntity<Object> hourly = getHttpEntity(
		        "{\"panelId\": \"1\", \"longitude\": \"54.12323295464\"," 
		            + " \"latitude\": \"54.123232\",\"brand\":\"tesla\" }");
   
    ResponseEntity<Panel> response = template.postForEntity(
        "/api/panels/1234567890123456/hourly", hourly, Panel.class);
    Assert.assertEquals(400,response.getStatusCode().value());
  }
  
  private HttpEntity<Object> getHttpEntity(Object body) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<Object>(body, headers);
  }
}
