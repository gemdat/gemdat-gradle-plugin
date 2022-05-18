package gemdat.gradle.plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

/**
 * Default task to extend/postfix base version with git-SHA or timestamp. 
 * @author beat.jost
 */
public class VersionTask extends DefaultTask {

	@TaskAction
	public void postfixVersion() {
		setGroup("gemdat");
		setDescription("Sets a version postfix from Git-hash or date");
		mustRunAfter("classes");
		String hash = System.getenv("GIT_COMMIT");
		String postfix = hash != null ? hash.substring(0, 7) : new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String gemdatVersion = getProject().getVersion().toString() + '-' + postfix;
		System.out.println("Version -> " + gemdatVersion);
		getProject().setVersion(gemdatVersion);
		getProject().getAllprojects().forEach(p -> p.setVersion(gemdatVersion));
		getProject().getExtensions().findByType(VersionExtension.class).setVersion(gemdatVersion);
	}

}