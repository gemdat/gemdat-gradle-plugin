package gemdat.gradle.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

public class VersionTaskTest {

    @Test
    public void applyPluginToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply(GemdatPlugin.class);
        assertEquals(1, project.getTasks().size());
        Set<Task> task = project.getTasksByName("postfixVersion", false);
        assertFalse(task.isEmpty());
        assertTrue(task.toArray()[0] instanceof VersionTask);
    }
	
	@Test
	public void setVersion_fromDate() {
        Project project = ProjectBuilder.builder().build();
        assertEquals("unspecified", project.getVersion());
        project.getPlugins().apply(GemdatPlugin.class);
        VersionTask version = (VersionTask)project.getTasksByName("postfixVersion", false).toArray()[0];        
		version.postfixVersion();
		assertTrue(project.getVersion().toString().startsWith("unspecified-20"));
	}
	
}