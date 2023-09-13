package com.project.dao;

public class Select {

	private final String tableName;
	private StringBuilder selectQuery;
	private StringBuilder columns;
	private StringBuilder whereCondition;
	private StringBuilder orderByClause;
	private StringBuilder groupByClause;
	private StringBuilder limitClause;

	public Select(String tableName) {
		this.tableName = tableName;
		selectQuery = new StringBuilder();
		columns = new StringBuilder();
		whereCondition = new StringBuilder();
		orderByClause = new StringBuilder();
		groupByClause = new StringBuilder();
		limitClause = new StringBuilder();
	}

	public void selectAll() {
		columns.setLength(0);
		columns.append("*");
	}

	public void selectColumn(String columnName) {
		if (columns.length() > 0 && !columns.toString().equals("*")) {
			columns.append(", ");
		}
		columns.append(columnName);
	}

	public void where(String condition, String logical_Operator) {
		if (whereCondition.length() > 0) {
			whereCondition.append(" AND ");
		}
		whereCondition.append(condition);
	}

	public void orderBy(String orderBy) {
		if (orderByClause.length() > 0) {
			orderByClause.append(", ");
		}
		orderByClause.append(orderBy);
	}

	public void groupBy(String groupBy) {
		if (groupByClause.length() > 0) {
			groupByClause.append(", ");
		}
		groupByClause.append(groupBy);
	}

	public void limit(int limit) {
		limitClause.setLength(0);
		limitClause.append(" LIMIT ").append(limit);
	}

	public String getFinalQuery() {
		StringBuilder query = new StringBuilder(selectQuery);

		query.append("SELECT ");

		if (columns.length() > 0) {
			query.append(columns);
		} else {
			query.append("*");
		}

		query.append(" FROM ").append(tableName);

		if (whereCondition.length() > 0) {
			query.append(" WHERE ").append(whereCondition);
		}

		if (groupByClause.length() > 0) {
			query.append(" GROUP BY ").append(groupByClause);
		}

		if (orderByClause.length() > 0) {
			query.append(" ORDER BY ").append(orderByClause);
		}

		query.append(limitClause);

		return query.toString();
	}
}
