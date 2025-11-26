plugins {
    kotlin("jvm")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation(project(":caffe"))
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(17)
}
