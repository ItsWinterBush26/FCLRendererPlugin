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

        manifestPlaceholders["des"] = "LTW Renderer (OpenGL 3.1+)"
        manifestPlaceholders["renderer"] = "LTW:libltw.so:libEGL.so"
        manifestPlaceholders["boatEnv"] = mutableMapOf<String, String>().apply {
            put("LIBGL_USE_MC_COLOR", "1")
            put("LIBGL_GL", "31")
            put("LIBGL_ES", "3")
            put("LIBGL_NORMALIZE", "1")
            put("LIBGL_NOERROR", "1")
        }.run {
            var env = ""
            forEach { (key, value) ->
                env += "$key=$value:"
            }
            env.dropLast(1)
        }
        manifestPlaceholders["pojavEnv"] =
            manifestPlaceholders["boatEnv"] as String +
                    (mutableMapOf<String, String>().apply {
                        put("POJAV_RENDERER", "opengles3")
                    }.run {
                        var env = ":"
                        forEach { (key, value) ->
                            env += "$key=$value:"
                        }
                        env.dropLast(1)
                    })
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
        configureEach {
            resValue("string", "app_name", "LTW Renderer)
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
