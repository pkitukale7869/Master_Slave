package com.project.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.project.dao.Alter;

public class AlterTest {

	private Alter alterTable;

	@Before
	public void setUp() {
		alterTable = new Alter("employees");
	}

	@Test
	public void testAddColumn() {
		alterTable.addColumn("new_column", "INT");
		String query = alterTable.getFinalQuery();
		assertEquals("ALTER TABLE employees ADD new_column INT", query);
	}

	@Test
	public void testDropColumn() {
		alterTable.dropColumn("old_column");
		String query = alterTable.getFinalQuery();
		assertEquals("ALTER TABLE employees DROP COLUMN old_column", query);
	}

	@Test
	public void testRenameColumn() {
		alterTable.renameColumn("old_name", "new_name");
		String query = alterTable.getFinalQuery();
		assertEquals("ALTER TABLE employees CHANGE old_name TO new_name", query);
	}

	@Test
	public void testModifyColumn() {
		alterTable.modifyColumn("column_to_modify", "VARCHAR(255)");
		String query = alterTable.getFinalQuery();
		assertEquals("ALTER TABLE employees MODIFY COLUMN column_to_modify VARCHAR(255)", query);
	}

	@Test
	public void testMultipleAlterations() {
		alterTable.addColumn("new_column", "INT");
		alterTable.dropColumn("old_column");
		alterTable.renameColumn("old_name", "new_name");
		alterTable.modifyColumn("column_to_modify", "VARCHAR(255)");
		String query = alterTable.getFinalQuery();
		assertEquals(
				"ALTER TABLE employees ADD new_column INT, DROP COLUMN old_column, CHANGE old_name TO new_name, MODIFY COLUMN column_to_modify VARCHAR(255)",
				query);
	}

}
