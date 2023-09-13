//package com.project.dao;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//public class InsertOld {
//
//	private StringBuilder insertQuery = new StringBuilder();
//	private StringBuilder column = new StringBuilder();;
//	private StringBuilder values = new StringBuilder();
//	private List<String> valueSets = new ArrayList<>();
//    private Set<String> columns = new HashSet<>(); // Use a Set to store unique column names
//
//	private boolean firstValueSet = true;
//
//	public Insert(final String tableName) {
//		insertQuery.append("INSERT INTO ").append(tableName);
//	}
//
//	public void columnValue(String column, String value) {
//		if (column.length() > 0) {
//			column.append(", ");
//			values.append(", ");
//		}
//		column.append(column);
//		values.append(value);
//	}
//
////	public void columnMap(Map<String, String> columnOfMap) {
////		for (Map.Entry<String, String> key : columnOfMap.entrySet()) {
////			String column = key.getKey();
////			String value = key.getValue();
////			if (columns.length() > 0) {
////				columns.append(", ");
////				values.append(", ");
////			}
////			columns.append(column);
////			values.append(value);
////		}
////	}
//
//	public void clear() {
//		columns.setLength(0);
//		values.setLength(0);
//	}
//
//	public void columnListMap(List<Map<String, String>> columnListOfMaps) {
//		for (Map<String, String> columnOfMap : columnListOfMaps) {
//			columnMap(columnOfMap); // Call the existing columnMap method for each map
//		}
//	}
//
//	public void columnMap(Map<String, String> columnOfMap) {
//		StringBuilder values = new StringBuilder();
//		boolean firstColumn = true;
//
//		for (Map.Entry<String, String> entry : columnOfMap.entrySet()) {
//			if (!firstColumn) {
//				values.append(", ");
//			}
//			values.append("'").append(entry.getValue()).append("'");
//
//			// Add the column name to the Set to ensure uniqueness
//			columns.add(entry.getKey());
//
//			firstColumn = false;
//		}
//
//		valueSets.add("(" + values.toString() + ")");
//	}
//
//	public String getFinalQuery() {
//		StringBuilder columnsBuilder = new StringBuilder(String.join(", ", columns));
//		insertQuery.append(" (").append(columnsBuilder).append(") VALUES ");
//
//		boolean first = true;
//		for (String valueSet : valueSets) {
//			if (!first) {
//				insertQuery.append(", ");
//			}
//			insertQuery.append(valueSet);
//			first = false;
//		}
//
//		return insertQuery.toString();
//	}
//
//	public void appendValues() {
//		values.append(", ");
//
//	}
//}
