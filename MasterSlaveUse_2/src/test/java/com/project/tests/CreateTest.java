package com.project.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.project.dao.Create;

public class CreateTest {

	private Create createTable;

	@Before
	public void setUp() {
		createTable = new Create("employee");
	}

	@Test
	public void testCreateTableWithColumns() {
		createTable.addColumn("id", "INT", false, true, false); // Primary key, NOT NULL, and auto-increment
		createTable.addColumn("name", "VARCHAR(255)", false, true, false);
		createTable.addColumn("age", "INT", false, true, false);

		String query = createTable.getFinalQuery();

		assertEquals("CREATE TABLE employee (id INT, name VARCHAR(255), age INT)", query);
	}

	@Test
	public void testCreateTableWithPrimaryKeys() {
		createTable.addColumn("id", "INT", true, false, true); // Primary key, NOT NULL, and auto-increment
		createTable.addColumn("name", "VARCHAR(255)", true, true, false); // Primary key and NOT NULL
		createTable.addColumn("age", "INT", false, false, false); // Primary key and NOT NULL

		String query = createTable.getFinalQuery();

		assertEquals(
				"CREATE TABLE employee (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255), age INT NOT NULL, PRIMARY KEY (id, name))",
				query);
	}
}
