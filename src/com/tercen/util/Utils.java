package com.tercen.util;

import java.util.List;
import java.util.Optional;

import com.tercen.client.impl.TercenClient;
import com.tercen.model.impl.Project;
import com.tercen.service.ServiceError;

public class Utils {

	public static Project getTestProject(TercenClient client, String teamOrUser, String projectName)
			throws ServiceError {

		List startKey = List.of(teamOrUser, false, "2000");
		List endKey = List.of(teamOrUser, false, "2100");

		List<Project> projects = client.projectService.findByTeamAndIsPublicAndLastModifiedDate(startKey, endKey, 1000,
				0, false, true);

		Optional<Project> result = projects.stream().filter(p -> p.name.equals(projectName)).findAny();

		if (result.isPresent()) {
			return result.get();
		}

		Project new_project = new Project();
		new_project.name = projectName;
		new_project.acl.owner = teamOrUser;

		return client.projectService.create(new_project);
	}
}
