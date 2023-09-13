package com.project.dao;

import java.util.ArrayList;
import java.util.List;

public class Alter {

	private String tableName;
	private List<String> alterCommands = new ArrayList<>();

	/**
	 * 
	 * @param tableName
	 */
	public Alter(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 
	 * @param columnName
	 * @param dataType
	 */
	public void addColumn(String columnName, String dataType) {
		String alterCommand = "ADD " + columnName + " " + dataType;
		alterCommands.add(alterCommand);
	}

	/**
	 * 
	 * @param columnName
	 */
	public void dropColumn(String columnName) {
		String alterCommand = "DROP COLUMN " + columnName;
		alterCommands.add(alterCommand);
	}

	/**
	 * 
	 * @param oldName
	 * @param newName
	 */
	public void renameColumn(String oldName, String newName) {
		String alterCommand = "CHANGE " + oldName + " TO " + newName;
		alterCommands.add(alterCommand);
	}

	/**
	 * 
	 * @param columnName
	 * @param newDataType
	 */
	public void modifyColumn(String columnName, String newDataType) {
		String alterCommand = "MODIFY COLUMN " + columnName + " " + newDataType;
		alterCommands.add(alterCommand);
	}

	/**
	 * 
	 * @return
	 */
	public String getFinalQuery() {
		StringBuilder query = new StringBuilder("ALTER TABLE ").append(tableName).append(" ");
		for (int i = 0; i < alterCommands.size(); i++) {
			query.append(alterCommands.get(i));
			if (i < alterCommands.size() - 1) {
				query.append(", ");
			}
		}

		return query.toString();
	}

}
