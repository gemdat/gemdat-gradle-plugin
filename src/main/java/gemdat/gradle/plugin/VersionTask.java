package gemdat.gradle.plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class VersionTask extends DefaultTask {

    @TaskAction
    public void setVersion() {
       String hash = System.getenv("GIT_COMMIT");
       String postfix = hash != null ? hash.substring(0, 7) : new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
       String version = getProject().getVersion().toString() + '-' + postfix;
       System.out.println("Version: " + version);
       getProject().setVersion(version);
    }
	
}