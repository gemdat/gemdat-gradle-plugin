package gemdat.gradle.plugin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

public class VersionTaskTest {

    @Test
    public void applyPluginToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply(GemdatPlugin.class);
        assertEquals(1, project.getTasks().size());
        Set<Task> task = project.getTasksByName("version", false);
        assertFalse(task.isEmpty());
        assertTrue(task.toArray()[0] instanceof VersionTask);
    }
	
	@Test
	public void setVersion_fromDate() {
        Project project = ProjectBuilder.builder().build();
        assertEquals("unspecified", project.getVersion());
        project.getPlugins().apply(GemdatPlugin.class);
        VersionTask version = (VersionTask)project.getTasksByName("version", false).toArray()[0];        
		version.setVersion();
		assertTrue(project.getVersion().toString().startsWith("unspecified-2020"));
	}
	
}
