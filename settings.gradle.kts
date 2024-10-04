plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "konsist-test"
include("app")
include("lib")
include("architecture")
