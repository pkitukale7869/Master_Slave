package com.project.dao;

public class Truncate {
	private String tableName;

	public Truncate(String tableName) {
        this.tableName = tableName;
    }

	public String getFinalQuery() {
		StringBuilder query = new StringBuilder("TRUNCATE TABLE ").append(tableName);

		return query.toString();
	}
}
