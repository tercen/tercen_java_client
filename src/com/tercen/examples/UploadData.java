package com.tercen.examples;

import java.io.IOException;

import com.tercen.client.impl.TercenClient;
import com.tercen.model.impl.FileDocument;
import com.tercen.model.impl.Project;
import com.tercen.service.ServiceError;
import com.tercen.util.Utils;

public class UploadData {

	private static final String FILE_NAME = "src/main/resources/crabs-long.csv";
	private static final String TEAM_NAME = "test-team";
	private static final String PROJECT_NAME = "myproject";
	private static final String LOCALHOST_URL = "http://10.0.2.2:5402/";
	private static final String DOMAIN = "tercen";
	private static final String USERNAME = "test";
	private static final String PASSWORD = "test";
	
	private static String type = "zip"; //  either "zip", "csv" or "txt"

	public static void main(String[] args) {
		TercenClient client = new TercenClient(UploadData.LOCALHOST_URL);

		try {
			client.userService.connect2("tercen", "test", "test");
			final Project project = Utils.getProject(client, TEAM_NAME, PROJECT_NAME);

			if (type.equals("csv")) {
				FileDocument result = Utils.uploadCsvFile(LOCALHOST_URL, TEAM_NAME, PROJECT_NAME, DOMAIN, USERNAME, PASSWORD, FILE_NAME);
				System.out.println(result.toJson());
				System.out.println("CSV file uploaded");
			} else if (type.equals("zip")) {
				FileDocument result = Utils.uploadZipFile(LOCALHOST_URL, TEAM_NAME, PROJECT_NAME, DOMAIN, USERNAME, PASSWORD, FILE_NAME);
				System.out.println(result.toJson());
				System.out.println("Zip file uploaded");
			} else if (type.equals("txt")) {
				FileDocument file = new FileDocument();
				file.name = "hello.txt";
				file.projectId = project.id;
				file = client.fileService.upload(file, "hello".getBytes());
				System.out.println(file.toJson());
				System.out.println("Txt file uploaded");
			}
		} catch (ServiceError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
