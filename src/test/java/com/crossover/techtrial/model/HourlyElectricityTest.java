package com.crossover.techtrial.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.annotation.JsonIgnore;
@RunWith(SpringJUnit4ClassRunner.class)
public class HourlyElectricityTest {
	@Test
	public void typeAnnotations() {
		// assert
		AssertAnnotationsHelper.assertType(
				HourlyElectricity.class, Entity.class, Table.class);
	}

	@Test
	public void fieldAnnotations() {
		Class twoAnnotation[] = {NotNull.class,Column.class};
		Class primaryAnnotations[] = {javax.persistence.Id.class,GeneratedValue.class};
		Class threeAnnotations[] = {NotNull.class, ManyToOne.class, JoinColumn.class};
		AssertAnnotationsHelper.assertField(HourlyElectricity.class, "id",primaryAnnotations);
		AssertAnnotationsHelper.assertField(HourlyElectricity.class, "panel",threeAnnotations);
		AssertAnnotationsHelper.assertField(HourlyElectricity.class, "generatedElectricity", twoAnnotation);
		AssertAnnotationsHelper.assertField(HourlyElectricity.class, "readingAt", twoAnnotation);

	}

	

	@Test
	public void entity() {
		Entity a= ReflectToolHelper.getClassAnnotation(HourlyElectricity.class, Entity.class);
		Assert.assertEquals("", a.name());
	}

	@Test
	public void table() {
		// setup
		Table t= ReflectToolHelper.getClassAnnotation(HourlyElectricity.class, Table.class);
		// assert
		Assert.assertEquals("hourly_electricity", t.name());

	}

	@Test 
	public void equalsAndHashCode() {
		// setup
		HourlyElectricity panel=new HourlyElectricity();
		panel.setId(1L);
		HourlyElectricity samePanel=new HourlyElectricity();
		samePanel.setId(1L);
		HourlyElectricity diffPanel=new HourlyElectricity();
		diffPanel.setId(2L);
		//assert
		Set<HourlyElectricity> set =new HashSet<HourlyElectricity>();
		set.add(panel);
		Assert.assertFalse(set.add(samePanel));
		Assert.assertTrue(set.add(diffPanel));
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Test
	public void panel() {
		// setup
		JoinColumn c= ReflectToolHelper.getFieldAnnotation(
		HourlyElectricity.class, "panel", JoinColumn.class);
		// assert
		Assert.assertEquals("panel_id", c.name());

	}

	@Test
	public void generatedElectricity() {
		// setup
		Column c= ReflectToolHelper.getFieldAnnotation(
		HourlyElectricity.class, "generatedElectricity", Column.class);
		// assert
		Assert.assertEquals("generated_electricity", c.name());
	}

	@Test
	public void readingAt() {
		// setup
		Column a= ReflectToolHelper.getFieldAnnotation(
		HourlyElectricity.class, "readingAt", Column.class);
		// assert
		Assert.assertEquals("reading_at", a.name());

	}
}
