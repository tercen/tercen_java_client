package tercen_java_client;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.tercen.client.impl.TercenClient;
import com.tercen.model.impl.FileDocument;
import com.tercen.model.impl.Project;
import com.tercen.model.impl.User;
import com.tercen.model.impl.UserSession;
import com.tercen.service.ServiceError;

public class TestTercenClient {

	@Test
	public void test_user_connect() throws ServiceError {

		TercenClient client = new TercenClient(TestUtils.LOCALHOST_URL);

		UserSession userSession = client.userService.connect2("tercen", "test", "test");
		System.out.println(userSession.toJson());
		System.out.println(userSession);

	}

	@Test
	public void test_get() throws ServiceError {

		TercenClient client = new TercenClient(TestUtils.LOCALHOST_URL);
		client.userService.connect2("tercen", "test", "test");

		User user = client.userService.get("test");

		System.out.println(user.toJson());
		System.out.println(user);
	}

	@Test
	public void test_project_create() throws ServiceError {

		TercenClient client = new TercenClient(TestUtils.LOCALHOST_URL);
		client.userService.connect2("tercen", "test", "test");

		final Project project = TestUtils.getTestProject(client, "test", "java-unit-test");

		client.projectService.delete(project.id, project.rev);

	}

	@Test
	public void test_project_find() throws ServiceError {

		TercenClient client = new TercenClient(TestUtils.LOCALHOST_URL);

		client.userService.connect2("tercen", "test", "test");

		final Project project = TestUtils.getTestProject(client, "test", "java-unit-test");

		List startKey = List.of("test", false, "2000");
		List endKey = List.of("test", false, "2100");

		List<Project> projects = client.projectService.findByTeamAndIsPublicAndLastModifiedDate(startKey, endKey, 1000,
				0, false, true);

		Optional<Project> result = projects.stream().filter(p -> p.id.equals(project.id)).findAny();

		Assert.assertTrue(result.isPresent());

		client.projectService.delete(project.id, project.rev);

	}

	@Test
	public void test_file_upload() throws ServiceError {

		TercenClient client = new TercenClient(TestUtils.LOCALHOST_URL);

		client.userService.connect2("tercen", "test", "test");

		final Project project = TestUtils.getTestProject(client, "test", "java-unit-test");

		FileDocument file = new FileDocument();
		file.name = "hello.txt";
		file.projectId = project.id;

		file = client.fileService.upload(file, "hello".getBytes());

		System.out.println(file.toJson());

		byte[] bytes = client.fileService.download(file.id);

		Assert.assertArrayEquals("hello".getBytes(), bytes);

		client.projectService.delete(project.id, project.rev);
	}

	@Test
	public void test_file_append() throws ServiceError {

		TercenClient client = new TercenClient(TestUtils.LOCALHOST_URL);

		client.userService.connect2("tercen", "test", "test");

		final Project project = TestUtils.getTestProject(client, "test", "java-unit-test");

		FileDocument file = new FileDocument();
		file.name = "hello.txt";
		file.projectId = project.id;

		file = client.fileService.append(file, "hello".getBytes());
		file = client.fileService.append(file, "salut".getBytes());

		byte[] bytes = client.fileService.download(file.id);

		Assert.assertArrayEquals("hellosalut".getBytes(), bytes);

		client.projectService.delete(project.id, project.rev);

	}

//	@Test
//	public void test_select_table() throws ServiceError {
//
//		TercenClient client = new TercenClient(TestUtils.LOCALHOST_URL);
//
//		client.userService.connect2("tercen", "test", "test");
// 
//		Schema schema = client.tableSchemaService.get("31a2d5d899c430a1f1c482732c16242e");
//
//		List<String> cnames = schema.columns.stream().map(column -> column.name).collect(Collectors.toList());
//
//		Table tbl = client.tableSchemaService.select(schema.id, cnames, 0, 100);
//
//		for (Column column : tbl.columns ) {
//			Object values =  column.values;
//			 
//			if (values instanceof double[]) {
//				for (double d :  (double[]) values) {
//					System.out.println(d);
//				}
//			}
//			else if (values instanceof CStringList) {
//				CStringList list = (CStringList)values;
//				for (int i = 0 ; i < list.size(); i++) {
//					System.out.println(list.get(i));
//				}
//			} else {
//				System.out.println(values);
//			}
//			
//		}
//	}
}
