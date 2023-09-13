package com.project.tests;

import org.junit.Before;
import org.junit.Test;

import com.project.dao.Delete;

import static org.junit.Assert.assertEquals;

public class DeleteTest {

	private Delete delete;

	@Before
	public void setUp() {
		delete = new Delete("users");
	}

	@Test
	public void testDeleteWithWhereClause() {
		delete.where("id = 1", "AND");
		String query = delete.getFinalQuery();
		assertEquals("DELETE FROM users WHERE id = 1", query);
	}

	@Test
	public void testDeleteWithWhereOrClause() {
		delete.where("age > 30", "AND");
		String query = delete.getFinalQuery();
		assertEquals("DELETE FROM users WHERE age > 30 OR status = 'inactive'", query);
	}

	@Test
	public void testDeleteNoWhereClause() {
		String query = delete.getFinalQuery();
		assertEquals("DELETE FROM users", query);
	}

}
