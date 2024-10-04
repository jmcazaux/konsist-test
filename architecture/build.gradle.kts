plugins {
    kotlin("jvm")
}

group = "com.ironbird"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation(project(":lib"))
    testImplementation(project(":app"))

    testImplementation(kotlin("test"))
    testImplementation("com.lemonappdev:konsist:0.16.1")
    testImplementation("io.kotest:kotest-runner-junit5:5.9.1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}