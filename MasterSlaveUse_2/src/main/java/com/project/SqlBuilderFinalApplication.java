package com.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.project.service.Service;

@SpringBootApplication
@ComponentScan(basePackages = "com.project")
public class SqlBuilderFinalApplication {

	public static void main(String[] args) {

		List<Map<String, String>> dataList = new ArrayList<>();

		Map<String, String> record1 = new HashMap<>();
		record1.put("firstName", "AAAA");
		record1.put("lastName", "BBB");
		record1.put("age", "1");

		Map<String, String> record2 = new HashMap<>();
		record2.put("firstName", "CCCC");
		record2.put("lastName", "DDDD");
		record2.put("age", "02");

		Map<String, String> record3 = new HashMap<>();
		record3.put("firstName", "Eeee");
		record3.put("lastName", "Ffff");
		record3.put("age", "25");

		Map<String, String> record4 = new HashMap<>();
		record4.put("firstName", "ggg");
		record4.put("lastName", "hh");
		record4.put("age", "3");

		dataList.add(record1);
		dataList.add(record2);
		dataList.add(record3);
		dataList.add(record4);

		Service serve = new Service();
		serve.insertEmployeeDataMapList(dataList);

		SpringApplication.run(SqlBuilderFinalApplication.class, args);
	}

}
