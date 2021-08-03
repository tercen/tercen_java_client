package com.tercen.examples;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

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

	private static String type = "csv"; // "txt"

	public static void main(String[] args) {
		TercenClient client = new TercenClient(UploadData.LOCALHOST_URL);

		try {
			client.userService.connect2("tercen", "test", "test");
			final Project project = Utils.getTestProject(client, TEAM_NAME, PROJECT_NAME);

			if (type.equals("csv")) {
				FileDocument fileDoc = new FileDocument();
				String[] filenameParts = FILE_NAME.split("/");
				fileDoc.name = filenameParts[filenameParts.length - 1];
				fileDoc.projectId = project.id;
				fileDoc.acl.owner = project.acl.owner;
				fileDoc.metadata = new CSVFileMetadata();
				fileDoc.metadata.contentType = "text/csv";
				fileDoc.metadata.separator = ",";
				fileDoc.metadata.quote = "\"";
				fileDoc.metadata.contentEncoding = "iso-8859-1";

				File file = new File(FILE_NAME);
				byte[] bytes = FileUtils.readFileToByteArray(file);

				FileDocument result = client.fileService.upload(fileDoc, bytes);
				System.out.println(result.toJson());

//				CSVTask to remove file 
//				CSVTask task = new CSVTask();
//				task.state = new InitState();
//				task.fileDocumentId = result.id;
//				task.owner = project.acl.owner;
//				task.projectId = project.id;
//
//				Task newTask = client.taskService.create(task);
//				client.taskService.runTask(newTask.id);
//				newTask = client.taskService.waitDone(newTask.id);
//
//				if (newTask.state instanceof FailedState) {
//					System.out.println("CSVTask failed:");
//				} else {
//					System.out.println("CSVTask completed");
//				}

				byte[] bytesOutput = client.fileService.download(result.id);
				if (Arrays.equals(bytes, bytesOutput)) {
					System.out.println("OK");
				} else {
					System.out.println("NOK");
				}
			} else {
				FileDocument file = new FileDocument();
				file.name = "hello.txt";
				file.projectId = project.id;
				file = client.fileService.upload(file, "hello".getBytes());
				System.out.println(file.toJson());
			}
		} catch (ServiceError e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
