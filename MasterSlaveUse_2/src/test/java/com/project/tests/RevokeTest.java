package com.project.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.project.dao.Revoke;

public class RevokeTest {

	private Revoke revokeCommand;

	@Before
	public void setUp() {
		revokeCommand = new Revoke("SELECT");
	}

	@Test
	public void testRevokeCommand() {
		revokeCommand.from("employees");
		revokeCommand.on("Shubham");
		String command = revokeCommand.getFinalCommand();
		assertEquals("REVOKE SELECT FROM employees ON Shubham", command);
	}

	@Test
	public void testRevokeCommandWithHost() {
		revokeCommand.from("orders");
		revokeCommand.on("Dolly");
		revokeCommand.withHost("localhost");
		String command = revokeCommand.getFinalCommand();
		assertEquals("REVOKE SELECT FROM orders ON Dolly @ localhost", command);
	}

	@Test
	public void testRevokeCommandWithoutHost() {
		revokeCommand.from("products");
		revokeCommand.on("Shubham");
		String command = revokeCommand.getFinalCommand();
		assertEquals("REVOKE SELECT FROM products ON Shubham", command);
	}

	@Test
	public void testRevokeCommandWithoutTargetName() {
		revokeCommand.from("sales");
		String command = revokeCommand.getFinalCommand();
		assertEquals("REVOKE SELECT FROM sales", command);
	}

	@Test
	public void testRevokeCommandWithUpperCasePrivilege() {
		revokeCommand = new Revoke("INSERT");
		revokeCommand.from("inventory");
		revokeCommand.on("Dolly");
		String command = revokeCommand.getFinalCommand();
		assertEquals("REVOKE INSERT FROM inventory ON Dolly", command);
	}

}
