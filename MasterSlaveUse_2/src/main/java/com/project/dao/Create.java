package com.project.dao;

import java.util.ArrayList;
import java.util.List;

public class Create {

	private String tableName;
	private List<String> columnDefinitions = new ArrayList<>();
	private List<String> primaryKeys = new ArrayList<>();
	private List<String> autoIncrementColumns = new ArrayList<>();

	public Create(final String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 
	 * @param columnName
	 * @param dataType
	 * @param isPrimaryKey
	 * @param isNullable
	 * @param isAutoIncrement
	 */
	public void addColumn(String columnName, String dataType, boolean isPrimaryKey, boolean isNullable,
			boolean isAutoIncrement) {
		StringBuilder columnDef = new StringBuilder(columnName).append(" ").append(dataType);

		if (isPrimaryKey) {
			primaryKeys.add(columnName);
		}

		if (!isNullable) {
			columnDef.append(" NOT NULL");
		}

		if (isAutoIncrement) {
			columnDef.append(" AUTO_INCREMENT");
			autoIncrementColumns.add(columnName);
		}

		columnDefinitions.add(columnDef.toString());
	}

	/**
	 * 
	 * @return
	 */
	public String getFinalQuery() {
		StringBuilder query = new StringBuilder("CREATE TABLE ").append(tableName).append(" (");

		for (int i = 0; i < columnDefinitions.size(); i++) {
			query.append(columnDefinitions.get(i));
			if (i < columnDefinitions.size() - 1) {
				query.append(", ");
			}
		}

		if (!primaryKeys.isEmpty()) {
			query.append(", PRIMARY KEY (");
			for (int i = 0; i < primaryKeys.size(); i++) {
				query.append(primaryKeys.get(i));
				if (i < primaryKeys.size() - 1) {
					query.append(", ");
				}
			}
			query.append(")");
		}

		query.append(")");

		return query.toString();
	}

}
