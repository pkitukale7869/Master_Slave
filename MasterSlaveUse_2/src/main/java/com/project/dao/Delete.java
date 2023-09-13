package com.project.dao;

public class Delete {
	private StringBuilder deleteQuery;
	private StringBuilder whereCondition;
	/**
	 * 
	 * @param tableName
	 */
	public Delete(final String tableName) {
		deleteQuery = new StringBuilder();
		whereCondition = new StringBuilder();
		deleteQuery.append(" DELETE FROM ").append(tableName);
	}

	/**
	 * 
	 * @param condition
	 * @param logical_oprator
	 */
	public void where(final String condition, final String logical_oprator) {
		if (whereCondition.length() == 0) {
			whereCondition.append(condition);
		} else {
			whereCondition.append(" " + logical_oprator + " " + condition);
		}

	}

	/**
	 * 
	 * @return
	 */
	public String getFinalQuery() {
		if (whereCondition.length() > 0) {
			deleteQuery.append(" WHERE ").append(whereCondition);
		}
		return deleteQuery.toString();
	}
}
