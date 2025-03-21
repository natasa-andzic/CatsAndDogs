plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {

    buildFeatures {
        viewBinding = true
    }
    namespace = "com.natasa.catsanddogs"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.natasa.catsanddogs"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation(libs.logging.interceptor)

        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")  // Ensure you're using the correct version
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")  // For LiveData support
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")  // For coroutines support


        implementation(libs.com.github.bumptech.glide.glide)  // Use the latest version
        annotationProcessor(libs.compiler) // For Glide annotation processor


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}