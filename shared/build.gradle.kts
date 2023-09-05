plugins {
    kotlin("plugin.serialization") version "1.9.0"
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")

    id("app.cash.sqldelight") version "2.0.0"
}

kotlin {
    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
            export("com.mohamedrejeb.calf:calf-ui:0.1.1")
        }
//        extraSpecAttributes["resources"] =
//            "['src/commonMain/resources/**', 'src/iosMain/resources/**']"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                // For Adaptive UI components
                api("com.mohamedrejeb.calf:calf-ui:0.1.1")


                //Typist for typing animation
                api("tech.dev-scion:typist-cmp:1.0.0")

                implementation("io.ktor:ktor-client-core:2.3.3")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.3")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0-RC")
                //dependency injection
                with(Deps.Koin) {
                    api(core)
                    api(compose)
                    api(test)
                }
                //view model and flow etc
                with(Deps.Moko) {
                    api(mvvmCore)
                    api(mvvmCompose)
                    api(mvvmFlowCompose)
                }
                with(Deps.Voyager) {
                    implementation(navigator)
                }


//                implementation("app.cash.sqldelight:sqlite-driver:2.0.0")

//                implementation("com.squareup.sqldelight:runtime:2.0.0")
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:1.6.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.9.0")

                implementation("app.cash.sqldelight:android-driver:2.0.0")
                implementation("io.ktor:ktor-client-android:2.3.3")

            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("app.cash.sqldelight:native-driver:2.0.0")
                implementation("io.ktor:ktor-client-darwin:2.3.3")
            }
        }
    }
}


sqldelight {
    databases {
        create("Classy") {
            packageName.set("com.devscion.classy.db")
        }
    }
}


android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.devscion.classy"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}
