package com.project.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.project.dao.Grant;

public class GrantTest {

	private Grant grantCommand;

	@Before
	public void setUp() {
		grantCommand = new Grant("SELECT");
	}

	@Test
	public void testGrantCommand() {
		grantCommand.on("employees");
		grantCommand.to("Shubham");
		String command = grantCommand.getFinalCommand();
		assertEquals("GRANT SELECT ON employees TO Shubham", command);
	}

	@Test
	public void testGrantCommandWithHost() {
		grantCommand.on("orders");
		grantCommand.to("Dolly");
		grantCommand.withHost("localhost");
		String command = grantCommand.getFinalCommand();
		assertEquals("GRANT SELECT ON orders TO Dolly @ localhost", command);
	}

	@Test
	public void testGrantCommandWithoutHost() {
		grantCommand.on("products");
		grantCommand.to("Amit");
		String command = grantCommand.getFinalCommand();
		assertEquals("GRANT SELECT ON products TO Amit", command);
	}

	@Test
	public void testGrantCommandWithoutTargetName() {
		grantCommand.on("sales");
		String command = grantCommand.getFinalCommand();
		assertEquals("GRANT SELECT ON sales", command);
	}

	@Test
	public void testGrantCommandWithUpperCasePrivilege() {
		grantCommand = new Grant("INSERT");
		grantCommand.on("inventory");
		grantCommand.to("Amit");
		String command = grantCommand.getFinalCommand();
		assertEquals("GRANT INSERT ON inventory TO Amit", command);
	}

}
