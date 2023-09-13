package com.project.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author Shubham Kitukale
 */
public class Insert {

	private StringBuilder insertQuery = new StringBuilder();
	private Set<String> columns = new HashSet<>(); // Use a Set to store unique column names

	public Insert(String tableName) {
		insertQuery.append("INSERT INTO ").append(tableName);
	}

	/**
	 * @author Shubham Kitukale
	 * @implNote : Passing List of MAP to DAO Insert Class
	 * @param dataList
	 */
	public void insertDataList(List<Map<String, String>> dataList) {
		if (dataList.isEmpty()) {
			return;
		}

		Map<String, String> firstRecord = dataList.get(0);
		extractColumns(firstRecord);

		insertQuery.append(" (");

		boolean firstColumn = true;
		for (String column : columns) {
			if (!firstColumn) {
				insertQuery.append(", ");
			}
			insertQuery.append(column);
			firstColumn = false;
		}

		insertQuery.append(") VALUES ");

		boolean firstValueSet = true;
		for (Map<String, String> record : dataList) {
			if (!firstValueSet) {
				insertQuery.append(", ");
			}
			insertQuery.append("(");

			boolean firstValue = true;
			for (String column : columns) {
				if (!firstValue) {
					insertQuery.append(", ");
				}
				insertQuery.append("'").append(record.get(column)).append("'");
				firstValue = false;
			}

			insertQuery.append(")");
			firstValueSet = false;
		}
	}

	private void extractColumns(Map<String, String> record) {
		columns.addAll(record.keySet());
	}

	public String getFinalQuery() {
		return insertQuery.toString();
	}

}
