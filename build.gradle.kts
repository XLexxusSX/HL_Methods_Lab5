plugins {
    java
    application
//    id("org.openjfx.javafxplugin") version "0.1.0"
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "com.AlexeyPopov1984"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_23
    targetCompatibility = JavaVersion.VERSION_23
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.openjfx:javafx-controls:23")
    implementation("org.openjfx:javafx-fxml:23")
    implementation("org.openjfx:javafx-web:23")
}

javafx {
    version = "23"
    modules = listOf("javafx.controls", "javafx.fxml", "javafx.web")
}

application {
    mainClass.set("com.alexeypopov1984.Launcher")
}

tasks.named<JavaExec>("run") {
    doFirst {
        jvmArgs = listOf(
            "--module-path", configurations.runtimeClasspath.get().asPath,
            "--add-modules", "javafx.controls,javafx.fxml,javafx.web"
        )
    }
}

//tasks.named<JavaExec>("run") {
//    doFirst {
//        jvmArgs = listOf(
//            "--module-path", "C:/javafx-sdk-25.0.1/lib",
//            "--add-modules", "javafx.controls,javafx.fxml,javafx.web"
//        )
//    }
//}
