import java.util.Properties

plugins {
    id("com.android.library")
    id("com.google.dagger.hilt.android")
    kotlin("android")
    kotlin("kapt")
}

fun getLocalProperty(propertyName: String): String {
    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").reader())
    return properties.getProperty(propertyName)
}

android {
    namespace = Configuration.packageNetwork
    compileSdk = (Configuration.compileSdkVersion)

    defaultConfig {
        minSdk = Configuration.minSdkVersion
        version = Configuration.versionCode
        buildConfigField(
            "String",
            Configuration.BASE_URL,
            "\"${getLocalProperty(Configuration.BASE_URL)}\""
        )
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
        buildConfig = true
    }
}

dependencies {
    kapt(Dependencies.hiltCompiler)
    implementation(Dependencies.hilt)

    implementation(Dependencies.okHttp)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson)
    implementation(Dependencies.logginInterceptor)
    implementation(Dependencies.retrofitConverter)
}
