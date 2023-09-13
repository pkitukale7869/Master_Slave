package com.project.dao;

public class Update {
	private final String tableName;
    private StringBuilder updateQuery = new StringBuilder();
    private StringBuilder setClause = new StringBuilder();
    private StringBuilder whereCondition = new StringBuilder();

    public Update(String tableName) {
        this.tableName = tableName;
        updateQuery.append("UPDATE ").append(tableName);
    }

    public void set(String column, String value) {
        if (setClause.length() > 0) {
            setClause.append(", ");
        }
        setClause.append(column).append(" = ").append(value);
    }

    public void where(String condition) {
        if (whereCondition.length() > 0) {
            whereCondition.append(" AND ");
        }
        whereCondition.append(condition);
    }

    public String getFinalQuery() {
        StringBuilder query = new StringBuilder(updateQuery);

        query.append(" SET ").append(setClause);

        if (whereCondition.length() > 0) {
            query.append(" WHERE ").append(whereCondition);
        }

        return query.toString();
    }
}
