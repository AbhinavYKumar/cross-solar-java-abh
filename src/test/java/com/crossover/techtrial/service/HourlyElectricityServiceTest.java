package com.crossover.techtrial.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;

import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.repository.HourlyElectricityRepository;

@RunWith(MockitoJUnitRunner.class)
public class HourlyElectricityServiceTest {
	@Mock
	HourlyElectricityRepository hourlyElectricityRepository;
	@InjectMocks
	HourlyElectricityServiceImpl electricityServiceImpl;
	@Test
    public void testFindTheGreatestFromAllData() {
		org.springframework.data.domain.PageRequest pageRequest = new org.springframework.data.domain.PageRequest(0, 10);
		List<HourlyElectricity> list = new ArrayList<HourlyElectricity>();
        when(hourlyElectricityRepository.findAllByPanelIdOrderByReadingAtDesc(1234567890123456L, pageRequest)).thenReturn(new PageImpl<HourlyElectricity>(list));
        assertEquals(0, electricityServiceImpl.getAllHourlyElectricityByPanelId(1234567890123456L, pageRequest).size());
    }
}
