plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")

    // DB
    //id("com.android.application")
    id("com.google.gms.google-services")
}



android {
    namespace = "com.phorea"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.phorea"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Material
    implementation("com.google.android.material:material:1.7.0")

    // 시작 화면
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-ktx:1.8.2")

    // DB
    implementation(platform("com.google.firebase:firebase-bom"))
    implementation("com.google.firebase:firebase-analytics")
    implementation (platform("com.google.firebase:firebase-bom:31.2.0"))
    implementation ("com.google.firebase:firebase-database-ktx")
    implementation ("com.google.firebase:firebase-auth-ktx")
    implementation ("com.google.firebase:firebase-firestore-ktx")

    // kakaoMap
    implementation (files("libs/libDaumMapAndroid.jar"))

    // Constraint Layout
    implementation ("androidx.constraintlayout:constraintlayout:2.1.0")


}

