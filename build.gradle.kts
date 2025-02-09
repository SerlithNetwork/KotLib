plugins {
    java
    id("com.gradleup.shadow") version "8.3.0"
}

group = "net.serlith.lib.kotlib"
version = "2.1.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "SpigotMC"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$version")
}

val targetJavaVersion = 8
java {
    val javaVersion = JavaVersion.toVersion(targetJavaVersion)
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    if (JavaVersion.current() < javaVersion) {
        toolchain.languageVersion = JavaLanguageVersion.of(targetJavaVersion)
    }
}

tasks.compileJava {
    options.encoding = "UTF-8"

    if (targetJavaVersion >= 8 || JavaVersion.current().isJava8Compatible) {
        options.release.set(targetJavaVersion)
    }
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.shadowJar {
    archiveClassifier = ""
}

tasks.jar {
    archiveClassifier = "cache"
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
