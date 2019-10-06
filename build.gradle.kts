plugins {
    application
    kotlin("jvm") version "1.3.71"
    id("com.diffplug.gradle.spotless") version "4.3.1"
}

allprojects {
    apply(plugin = "com.diffplug.gradle.spotless")

    spotless {
        kotlin {
            ktlint("0.37.2")
        }
        kotlinGradle {
            ktlint("0.37.2")
        }
    }
}

application {
    mainClassName = "MainKt"
}

object Version {
    const val JUNIT = "5.6.1"
}

dependencies {
    compile(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    testImplementation(kotlin("test-junit5"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Version.JUNIT}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${Version.JUNIT}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Version.JUNIT}")
}

repositories {
    jcenter()
}

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "6.3"
    }

    withType<Test> {
        useJUnitPlatform()
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}
