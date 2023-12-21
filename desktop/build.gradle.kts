plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group = "com.devscion.classy"
version = "1.0.0"

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "17"
        }
    }

    sourceSets {
        val jvmMain by getting {
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                implementation(compose.desktop.currentOs)

                implementation(project(":shared"))
            }
        }
    }

}
