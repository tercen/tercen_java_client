package com.tercen.examples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.tercen.client.impl.TercenClient;
import com.tercen.model.impl.CSVFileMetadata;
import com.tercen.model.impl.FileDocument;
import com.tercen.model.impl.Project;
import com.tercen.service.ServiceError;
import com.tercen.util.Utils;

public class UploadData {

	private static final String FILE_NAME = "src/main/resources/crabs-long.csv";
	private static final String TEAM_NAME = "test-team";
	private static final String PROJECT_NAME = "myproject";
	private static final String LOCALHOST_URL = "http://127.0.0.1:5402/";

	public static void main(String[] args) {
		TercenClient client = new TercenClient(UploadData.LOCALHOST_URL);

		try {
			client.userService.connect2("tercen", "test", "test");
			final Project project = Utils.getTestProject(client, TEAM_NAME, PROJECT_NAME);

			FileDocument fileDoc = new FileDocument();
			fileDoc.name = "crabs_data";
			fileDoc.projectId = project.id;
			fileDoc.acl.owner = project.acl.owner;
			fileDoc.metadata = new CSVFileMetadata();
			fileDoc.metadata.contentType = "text/csv";
			// file.metadata = ",";
			// file.metadata = "text/csv";
			fileDoc.metadata.contentEncoding = "text/csv";

			File file = new File(FILE_NAME);
			byte[] bytes = FileUtils.readFileToByteArray(file);

			FileDocument result = client.fileService.upload(fileDoc, bytes);

			System.out.println(result.toJson());

		} catch (ServiceError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
