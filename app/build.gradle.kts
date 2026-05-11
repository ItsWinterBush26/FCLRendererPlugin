plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.bzlzhh.plugin.ngg"
    compileSdk = 34

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.bzlzhh.plugin.ngg"
        minSdk = 26
        targetSdk = 34
        versionCode = 45
        versionName = "Release 2026"

        ndk {
            abiFilters += "arm64-v8a"
        }

        manifestPlaceholders["des"] =
            "LTW Renderer (OpenGL 3.1+)"

        // safer than libEGL.so
        manifestPlaceholders["renderer"] =
            "LTW:libltw.so:libltw.so"

        manifestPlaceholders["boatEnv"] =
            "LIBGL_USE_MC_COLOR=1:" +
            "LIBGL_GL=31:" +
            "LIBGL_ES=3:" +
            "LIBGL_NORMALIZE=1:" +
            "LIBGL_NOERROR=1"

        manifestPlaceholders["pojavEnv"] =
            "LIBGL_USE_MC_COLOR=1:" +
            "LIBGL_GL=31:" +
            "LIBGL_ES=3:" +
            "LIBGL_NORMALIZE=1:" +
            "LIBGL_NOERROR=1:" +
            "POJAV_RENDERER=opengles3"
    }

    buildTypes {

        debug {
            resValue("string", "app_name", "LTW Renderer")
        }

        release {
            isMinifyEnabled = false

            resValue("string", "app_name", "LTW Renderer")
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
    implementation(project(":LTW"))
}
