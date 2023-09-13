package com.project.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.project.dao.Truncate;

public class TruncateTest {

	private Truncate truncateTable;

	@Before
	public void setUp() {
		truncateTable = new Truncate("employees");
	}

	@Test
	public void testTruncateTable() {
		String query = truncateTable.getFinalQuery();
		assertEquals("TRUNCATE TABLE employees", query);
	}

	@Test
	public void testTruncateTableWithDifferentTableName() {
		truncateTable = new Truncate("orders");
		String query = truncateTable.getFinalQuery();
		assertEquals("TRUNCATE TABLE orders", query);
	}

	@Test
	public void testTruncateTableWithUpperCaseTableName() {
		truncateTable = new Truncate("USERS");
		String query = truncateTable.getFinalQuery();
		assertEquals("TRUNCATE TABLE USERS", query);
	}

	@Test
	public void testTruncateTableWithSpecialCharactersInTableName() {
		truncateTable = new Truncate("table#1");
		String query = truncateTable.getFinalQuery();
		assertEquals("TRUNCATE TABLE table#1", query);
	}

	@Test
	public void testTruncateTableWithLongTableName() {
		String longTableName = "very_long_table_name_that_should_still_work";
		truncateTable = new Truncate(longTableName);
		String query = truncateTable.getFinalQuery();
		assertEquals("TRUNCATE TABLE very_long_table_name_that_should_still_work", query);
	}

}
