import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
import com.bmuschko.gradle.docker.tasks.image.*

plugins {
    id("org.springframework.boot") version "2.4.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.bmuschko.docker-remote-api") version "6.7.0"
    kotlin("jvm") version "1.4.30"
    kotlin("plugin.spring") version "1.4.30"
    kotlin("plugin.jpa") version "1.4.30"
}

val dockerImageName = "weaxme/bookstore"

group = "com.weaxme"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_14

springBoot {
    mainClass.set("com.weaxme.bookstore.BookstoreApplicationKt")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "14"
        }
    }

    withType<BootJar> {
        archiveClassifier.set("boot")
    }

    withType<JavaCompile> {
        sourceCompatibility = "14"
        targetCompatibility = "14"
    }

    withType<Test> {
        useJUnitPlatform()
    }

    val dockerBuild = create("dockerBuild", DockerBuildImage::class) {
        inputDir.set(file("."))
        images.add("$dockerImageName:$version")
    }

    create("dockerPush", DockerPushImage::class) {
        dependsOn(dockerBuild)
        images.set(dockerBuild.images)
    }
}
