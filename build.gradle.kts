plugins {
    kotlin("jvm") version "1.3.72"
    maven
}

repositories {
    jcenter()
    maven { setUrl("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    api(kotlin("stdlib-jdk8"))
    compileOnly("com.destroystokyo.paper", "paper-api", "1.15.2-R0.1-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn"
        )
    }
}