package com.tercen.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.tercen.client.impl.TercenClient;
import com.tercen.model.impl.Schema;
import com.tercen.model.impl.Table;
import com.tercen.service.ServiceError;

public class SelectData {

	private static final String LOCALHOST_URL = "http://10.0.2.2:5402/";
	private static final String DOMAIN = "tercen";
	private static final String USERNAME = "test";
	private static final String PASSWORD = "test";
	private static final String TABLE_ID = "06b38fe91c2ed72a148b3fa38702b81e";
	
	public static void main(String[] args) {
		TercenClient client = new TercenClient(SelectData.LOCALHOST_URL);

		try {
			client.userService.connect2(DOMAIN, USERNAME, PASSWORD);
			
			Schema schema = client.tableSchemaService.get(TABLE_ID);
			List<String> list = schema.columns.stream().map(c -> c.name).collect(Collectors.toList());
			ArrayList<String> cnames = new ArrayList<String>(list);
			
			Table result = client.tableSchemaService.select(TABLE_ID, cnames, 0, 100);			
			double[] colvals = (double []) result.columns.get(0).values;
			for (double d :  (double[]) colvals) {
				System.out.println(d);
			}
			
		} catch (ServiceError e) {
			e.printStackTrace();
		} 
	}
}
