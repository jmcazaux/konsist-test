plugins {
    kotlin("jvm")
}

group = "com.ironbird"
version = "1.0-SNAPSHOT"

repositories {
    // Konsist snapshot repository
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")

    mavenCentral()
}

dependencies {

    testImplementation(project(":lib"))
    testImplementation(project(":app"))

    testImplementation(kotlin("test"))
    testImplementation("com.lemonappdev:konsist:0.17.3")
    testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
