package com.project.dao;

public class Drop {

	    private String tableName;

	    public Drop(String tableName) {
	        this.tableName = tableName;
	    }

	    public String getFinalQuery() {
	        StringBuilder query = new StringBuilder("DROP TABLE ")
	                .append(tableName);

	        return query.toString();
	    }

}
