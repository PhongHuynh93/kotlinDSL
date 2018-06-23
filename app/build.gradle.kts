import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig
import org.gradle.kotlin.dsl.extra
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.setValue


plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    buildToolsVersion(Config.Android.buildToolsVersion)

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Config.Libs.kotlin_std)
    implementation(Config.Libs.appcompat)
    implementation(Config.Libs.recyclerview)
    implementation(Config.Libs.cardview)
    implementation(Config.Libs.palette)
    implementation(Config.Libs.design)
    implementation(Config.Libs.eventbus)
    implementation(Config.Libs.picasso)
    implementation(Config.Libs.okhttp)
    implementation(Config.Libs.okhttp_interceptor)
    implementation(Config.Libs.retrofit)
    implementation(Config.Libs.retrofit_gson)
    implementation(Config.Libs.jobqueue)
    implementation(Config.Libs.anko_sdk15)
    implementation(Config.Libs.anko_support)
    implementation(Config.Libs.anko_appcompat)
    implementation(Config.Libs.anko_design)
    implementation(Config.Libs.anko_cardview)
    implementation(Config.Libs.anko_recyclerview)
    implementation(Config.Libs.constraintLayout)
    kapt(Config.Libs.dagger_compiler)
    implementation(Config.Libs.dagger)

    testCompile(Config.TestLibs.junit)
    testCompile(Config.TestLibs.mockito)

    androidTestCompile(Config.TestLibs.mockito)
    androidTestCompile(Config.TestLibs.dexmaker)
    androidTestCompile(Config.TestLibs.dexmaker_mockito)
    androidTestCompile(Config.TestLibs.annotations)
    androidTestCompile(Config.TestLibs.espresso)
}
