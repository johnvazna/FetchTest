/** */
object Dependencies {

    //Testing

    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val androidTest by lazy { "androidx.test.ext:junit:${Versions.androidTest}" }
    val roboElectric by lazy { "org.robolectric:robolectric:${Versions.roboElectric}" }

    //Core

    val composeUI by lazy { "androidx.compose.ui:ui" }
    val composeMaterial by lazy { "androidx.compose.material:material" }
    val core by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val composeRxJava by lazy { "androidx.compose.runtime:runtime-rxjava2" }
    val composeFoundation by lazy { "androidx.compose.foundation:foundation" }
    val composeLiveData by lazy { "androidx.compose.runtime:runtime-livedata" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val composeBoom by lazy { "androidx.compose:compose-bom:${Versions.compose}" }
    val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview-android:+" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val navigationUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }
    val composeActivity by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }

    //LifeCycle

    val lifeCycle by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}" }

    //Coroutines

    val coroutinesTesting by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTesting}" }

    //Network

    val gson by lazy { "com.google.code.gson:gson:${Versions.gsonVersion}" }
    val okHttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
    val retrofitConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}" }
    val logginInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}" }

    //DI

    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val reflect by lazy { "org.jetbrains.kotlin:kotlin-reflect:${Versions.reflect}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
}
