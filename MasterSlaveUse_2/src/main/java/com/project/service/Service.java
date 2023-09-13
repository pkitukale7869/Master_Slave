package com.project.service;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.project.dao.Delete;
import com.project.dao.Insert;
import com.project.dao.Select;
import com.project.dao.Update;

@Component
public class Service {
	/*
	//APPROACH 1 OF USING DATASOURCE
	
	@Autowired
	@Qualifier("master1")
	private JdbcTemplate jdbcTemplateMaster1;

	@Autowired
	@Qualifier("slave1")
	private JdbcTemplate jdbcTemplateSlave1;
*/
	//APPROACH 2 OF USING DATASOURCE AS A CONSTRUCTOR 
	 
	private JdbcTemplate jdbcTemplate1;
    private JdbcTemplate jdbcTemplate2;

    @Autowired
    public void EmployeeService(@Qualifier("master1") DataSource dataSource1,
                           @Qualifier("slave1") DataSource dataSource2) {
        this.jdbcTemplate1 = new JdbcTemplate(dataSource1);
        this.jdbcTemplate2 = new JdbcTemplate(dataSource2);
    }

	/**
	 * @implNote It will take all the data from DB
	 * @author Shubham Kitukale
	 * @return
	 */
	public List<Map<String, Object>> getAllEmployeeDetails() {
		try {
			Select builder = new Select("employees_table");

			builder.selectAll();

			String query = builder.getFinalQuery();
			return jdbcTemplate2.queryForList(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * @implNote It will accept the condition and logical operator and acccordingly
	 *           provide the data from DB
	 * @author Shubham Kitukale
	 * @param condition
	 * @return
	 */
	public List<Map<String, Object>> getDetailsByIdPass(String condition, String logical_Operator) {
		try {
			Select builder = new Select("employees_table");

			builder.selectAll();
			builder.where(condition, logical_Operator);

			String query = builder.getFinalQuery();
			return jdbcTemplate2.queryForList(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @author Shubham Kitukale
	 * @param dataList
	 */
	public void insertEmployeeDataMapList(List<Map<String, String>> dataList) {
		try {
			Insert builder = new Insert("employees_table");
			builder.insertDataList(dataList); // Pass the list of maps directly to the Insert class

			String query = builder.getFinalQuery();
			System.out.println("Generated Query: " + query); // Print the generated query
			jdbcTemplate1.update(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * @implNote Method can take MAP as input and build the query
 * @author Shubham Kitukale
 * @param columnValueMap
 * @return
 * 
 *         public Map<String, Object> insertEmployeeDataMap(Map<String, String>
 *         columnValueMap) { try { Insert builder = new
 *         Insert("employees_table");
 * 
 *         builder.columnMap(columnValueMap);
 * 
 *         String query = builder.getFinalQuery(); System.out.println("Query
 *         Genrated " + query); } catch (Exception e) { e.printStackTrace(); }
 *         return null; }
 */

/**
 * CODE RUNNING PROPERLY BREAKING LIST OF MAPS AND PASSING MAPS TO DAO INSERT
 * CLASS
 * 
 * @implNote : Method can take LIST OF MAP as input and build the query
 * @author Shubham Kitukale
 * @param dataList
 */
//	public void insertEmployeeDataMapList(List<Map<String, String>> dataList) {
//		try {
//			Insert builder = new Insert("employees_table");
//
//			for (Map<String, String> columnValueMap : dataList) {
//				builder.columnMap(columnValueMap);
//			}
//
//			String query = builder.getFinalQuery();
//			System.out.println("Generated Query: " + query); // Print the generated query
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

/**
 * @implNote Method which is taking only String as Input
 * @param firstNameIp
 * @return
 */
//	public List<Map<String, Object>> insertEmployeeData(String firstNameIp) {
//		try {
//			Insert builder = new Insert("employees_table");
//
//			builder.columnValue("firstName", firstNameIp);
//
//			String query = builder.getFinalQuery();
//			System.out.println(query);
////			return jdbcTemplate.queryForList(query);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
