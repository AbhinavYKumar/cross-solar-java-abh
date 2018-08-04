package com.crossover.techtrial.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
public class PanelTest {
	@Test
	public void typeAnnotations() {
		// assert
		AssertAnnotationsHelper.assertType(
				Panel.class, Entity.class, Table.class);
	}
	@Test
	public void fieldAnnotations() {
		Class twoAnnotationsWithNotNull[] = {NotNull.class,Column.class};
		Class oneAnnotation[] = {Column.class};
		Class twoAnnotationsWithOutNull[] = {Nullable.class,Column.class};
		Class primaryAnnotations[] = {javax.persistence.Id.class,GeneratedValue.class};
		AssertAnnotationsHelper.assertField(Panel.class, "id",primaryAnnotations);
		AssertAnnotationsHelper.assertField(Panel.class, "serial",twoAnnotationsWithNotNull);
		AssertAnnotationsHelper.assertField(Panel.class, "longitude", oneAnnotation);
		AssertAnnotationsHelper.assertField(Panel.class, "latitude", oneAnnotation);
		AssertAnnotationsHelper.assertField(Panel.class, "brand", twoAnnotationsWithOutNull);

	}
	@Test
	public void entity() {
		Entity a= ReflectToolHelper.getClassAnnotation(Panel.class, Entity.class);
		Assert.assertEquals("", a.name());
	}
	@Test
	public void table() {
		// setup
		Table t= ReflectToolHelper.getClassAnnotation(Panel.class, Table.class);
		// assert
		Assert.assertEquals("panel", t.name());

	}
	@Test 
	public void equalsAndHashCode() {
		// setup
		Panel panel=new Panel();
		panel.setId(1L);
		Panel samePanel=new Panel();
		samePanel.setId(1L);
		Panel diffPanel=new Panel();
		diffPanel.setId(2L);
		//assert
		Set<Panel> set =new HashSet<Panel>();
		set.add(panel);
		Assert.assertFalse(set.add(samePanel));
		Assert.assertTrue(set.add(diffPanel));
		// TODO Auto-generated constructor stub
	}
	@Test
	public void serial() {
		// setup
		Column c= ReflectToolHelper.getFieldAnnotation(
		Panel.class, "serial", Column.class);
		// assert
		Assert.assertEquals("serial", c.name());

	}
	@Test
	public void longitude() {
		// setup
		Column c= ReflectToolHelper.getFieldAnnotation(
		Panel.class, "longitude", Column.class);
		// assert
		Assert.assertEquals("longitude", c.name());
	}
	@Test
	public void brand() {
		// setup
		Column a= ReflectToolHelper.getFieldAnnotation(
		Panel.class, "brand", Column.class);
		// assert
		Assert.assertEquals("brand", a.name());

	}
}
