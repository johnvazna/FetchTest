/** */
object Dependencies {

    //Testing

    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val androidTest by lazy { "androidx.test.ext:junit:${Versions.androidTest}" }
    val roboElectric by lazy { "org.robolectric:robolectric:${Versions.roboElectric}" }

    //Core

    val core by lazy { "androidx.core:core-ktx:${Versions.androidCore}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val navigationUI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}" }
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
