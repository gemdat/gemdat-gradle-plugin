# gemdat-gradle-plugin
 Gemdat Gradle-Plugin for generally used build tasks.
 
**version**

Takes the version from `gradle.properties` and adds a postfix with the first 7 chars of current git-commit, if not available the current date. (e.g. `1.4.0-8156a28`)
