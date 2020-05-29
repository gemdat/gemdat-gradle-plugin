package gemdat.gradle.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GemdatPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.getExtensions().create("gemdat", VersionExtension.class);
		VersionTask versiontask = project.getTasks().create("postfixVersion", VersionTask.class);
		//project.getGradle().getTaskGraph().whenReady(t -> versiontask.postfixVersion());
		project.afterEvaluate(pro -> {
			versiontask.postfixVersion();
		});
	}

}