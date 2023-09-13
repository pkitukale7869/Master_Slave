package com.project.tests;

import org.junit.Before;
import org.junit.Test;

import com.project.dao.Select;

import static org.junit.Assert.assertEquals;

public class SelectTest {

	private Select select;

	@Before
	public void setUp() {
		select = new Select("validate");
	}

	@Test
	public void testSelectAll() {
		select.selectAll();
		String query = select.getFinalQuery();
		assertEquals("SELECT * FROM validate", query);
	}

	@Test
	public void testSelectColumn() {
		select.selectColumn("password");
		select.selectColumn("age");
		String query = select.getFinalQuery();
		assertEquals("SELECT password, age FROM validate", query);
	}

	@Test
	public void testWhere() {
		select.where("age > 12", " AND ");
		select.where("userid = 1111", " ");
		String query = select.getFinalQuery();
		assertEquals("SELECT * FROM validate WHERE age > 12 AND userid = 1111", query);
	}

	@Test
	public void testOrderBy() {
		select.orderBy("Check DESC");
		select.orderBy("age ASC");
		String query = select.getFinalQuery();
		assertEquals("SELECT * FROM validate ORDER BY Check DESC, age ASC", query);
	}

	@Test
	public void testGroupBy() {
		select.groupBy("password");
		select.groupBy("age");
		String query = select.getFinalQuery();
		assertEquals("SELECT * FROM validate GROUP BY password, age", query);
	}

	@Test
	public void testLimit() {
		select.limit(30);
		String query = select.getFinalQuery();
		assertEquals("SELECT * FROM validate LIMIT 30", query);
	}
}