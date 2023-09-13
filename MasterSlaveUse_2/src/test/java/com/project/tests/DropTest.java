package com.project.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.project.dao.Drop;

public class DropTest {

	private Drop dropTable;

	@Before
	public void setUp() {
		dropTable = new Drop("employees");
	}

	@Test
	public void testDropTable() {
		String query = dropTable.getFinalQuery();
		assertEquals("DROP TABLE employees", query);
	}

}
