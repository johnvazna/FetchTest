plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    namespace = Configuration.packageApp
    compileSdk = (Configuration.compileSdkVersion)

    defaultConfig {
        applicationId = Configuration.packageApp
        minSdk = Configuration.minSdkVersion
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName
        targetSdk = Configuration.targetSdkVersion
        resValue("string", "app_name", "FetchTest")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            resValue("string", "app_name", "FetchTest")
        }
        create("dev") {
            initWith(getByName("debug"))
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
            applicationIdSuffix = ".dev"
            versionNameSuffix = "-dev"
            signingConfig = signingConfigs.getByName("debug")
            resValue("string", "app_name", "FetchTest[D]")
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

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hilt)

    implementation(Dependencies.core)
    implementation(Dependencies.kotlin)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.materialDesign)
}
