plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

android {

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    namespace = Configuration.packageHiring
    compileSdk = (Configuration.compileSdkVersion)

    defaultConfig {
        minSdk = Configuration.minSdkVersion
        version = Configuration.versionCode
    }

    buildTypes {
        create(Configuration.ENV_DEV) {
            initWith(getByName(Configuration.ENV_DEBUG))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    kapt {
        correctErrorTypes = true
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(Modules.core_module))
    implementation(project(Modules.network_module))

    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hilt)

    implementation(platform(Dependencies.composeBoom))
    implementation(Dependencies.composeUI)
    implementation(Dependencies.composeRxJava)
    implementation(Dependencies.composeFoundation)
    implementation(Dependencies.composeMaterial)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.composeLiveData)

    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")

    implementation(Dependencies.core)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.navigationUI)
    implementation(Dependencies.materialDesign)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.navigationFragment)

    implementation(Dependencies.okHttp)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson)
    implementation(Dependencies.lifeCycle)
    implementation(Dependencies.logginInterceptor)
    implementation(Dependencies.retrofitConverter)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.coroutinesTesting)
}
