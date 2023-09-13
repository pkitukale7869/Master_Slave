package com.project.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.project.dao.Insert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertTest {

	private Insert insert;

	@Before
	public void setUp() {
		insert = new Insert("employees_table");
	}

	@Test
	public void testInsertDataListWithSingleRecord() {
		List<Map<String, String>> dataList = new ArrayList<>();
		Map<String, String> record = new HashMap<>();
		record.put("firstName", "John");
		record.put("lastName", "Doe");
		record.put("age", "30");
		dataList.add(record);

		insert.insertDataList(dataList);
		String query = insert.getFinalQuery();
		String expectedQuery = "INSERT INTO employees_table (firstName, lastName, age) VALUES ('John', 'Doe', '30')";
		Assert.assertEquals("Query should match expected query for a single record", expectedQuery, query);
	}

	@Test
	public void testInsertDataListWithMultipleRecords() {
		List<Map<String, String>> dataList = new ArrayList<>();
		Map<String, String> record1 = new HashMap<>();
		record1.put("firstName", "Alice");
		record1.put("lastName", "Smith");
		record1.put("age", "25");
		dataList.add(record1);

		Map<String, String> record2 = new HashMap<>();
		record2.put("firstName", "Bob");
		record2.put("lastName", "Johnson");
		record2.put("age", "28");
		dataList.add(record2);

		insert.insertDataList(dataList);
		String query = insert.getFinalQuery();
		String expectedQuery = "INSERT INTO employees_table (firstName, lastName, age) VALUES "
				+ "('Alice', 'Smith', '25'), ('Bob', 'Johnson', '28')";
		Assert.assertEquals("Query should match expected query for multiple records", expectedQuery, query);
	}

}
