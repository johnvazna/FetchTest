plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = Configuration.packageCore
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
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hilt)

    implementation(Dependencies.core)
    implementation(Dependencies.gson)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.retrofit)
    implementation((Dependencies.okHttp))
    implementation(Dependencies.lifeCycle)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.materialDesign)
    implementation(Dependencies.constraintLayout)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.coroutinesTesting)
}
