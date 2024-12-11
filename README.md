# gemdat-gradle-plugin
 Gemdat Gradle-Plugin for generally used build tasks.
 
 *Gradle:* `plugins { id "ch.gemdat" version "1.2" }`
 
 To use it with SpringBoot just add the following to the build.gradle:
 `bootBuildInfo.dependsOn postfixVersion` 
 
**version**

Takes the version from `gradle.properties` and adds a postfix with the first 7 chars of current git-commit, if not available the current date. (e.g. `1.4.0-8156a28`)

**deploy**

To deploy you need to run the gradle plugin task: `./gradlew publishPlugins` <br/>
For details see: https://docs.gradle.org/current/userguide/publishing_gradle_plugins.html