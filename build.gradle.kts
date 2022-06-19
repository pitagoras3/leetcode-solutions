plugins {
    kotlin("jvm") version "1.7.0"
}

group = "dev.marcinkiewicz"
version = "0.0.1"

repositories {
    mavenCentral()
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

val kotestVersion = "5.3.1"

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}
