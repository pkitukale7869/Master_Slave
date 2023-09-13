package com.project.tests;

import org.junit.Before;
import org.junit.Test;

import com.project.dao.Update;

import static org.junit.Assert.assertEquals;

public class UpdateTest {

	private Update update;

	@Before
	public void setUp() {
		update = new Update("users");
	}

	@Test
	public void testUpdateSingleColumn() {
		update.set("name", "'John'");
		String query = update.getFinalQuery();
		assertEquals("UPDATE users SET name = 'John'", query);
	}

	@Test
	public void testUpdateMultipleColumns() {
		update.set("name", "'John'");
		update.set("age", "30");
		String query = update.getFinalQuery();
		assertEquals("UPDATE users SET name = 'John', age = 30", query);
	}

	@Test
	public void testUpdateWithWhereClause() {
		update.set("name", "'John'");
		update.where("id = 1");
		String query = update.getFinalQuery();
		assertEquals("UPDATE users SET name = 'John' WHERE id = 1", query);
	}

	@Test
	public void testUpdateNoWhereClause() {
		update.set("name", "'John'");
		String query = update.getFinalQuery();
		assertEquals("UPDATE users SET name = 'John'", query);
	}

}
